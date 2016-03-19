import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ClientServer implements Runnable {

    InetAddress[] IPAddress = new InetAddress[3];
    DatagramSocket[] dSocket = new DatagramSocket[3];
    int[] serverdone = {
            -1, -1, -1
    };
    long[] servestart = {
            0L, 0L, 0L
    };

    int port;
    private GameSparker gs;
    private CheckPoints ch;
    static Object threadLock = new Object();

    public ClientServer(xtGraphics xtgraphics, GameSparker gs, CheckPoints ch, int port) {
        this.port = port;
        this.xtgraphics = xtgraphics;
        this.gs = gs;
        this.ch = ch;
        xtgraphics.im = -1;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        System.out.println("running");
        try {
            synchronized (threadLock) {
                serverSocket = new ServerSocket(port);
            }
            System.out.println("made a socket in port " + port);
            while (true) {
                final Socket clientSocket = serverSocket.accept();
                final PrintWriter _UNUSED_ = new PrintWriter(clientSocket.getOutputStream(), true); //TODO FIXME XXX WHATEVER
                final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;

                // Initiate conversation with client
                //outputLine = kkp.processInput(null);
                //out.println(outputLine);

                while ((inputLine = in.readLine()) != null) {
                    processInput(inputLine);
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException | NullPointerException e1) {
            }
        }
    }

    private xtGraphics xtgraphics;
    private String processInput(String in) {
        System.out.println("client received " + in);

        if (in.startsWith("start|")) {
            // first parameter after start - stage
            ch.stage = getvalue(in, 2);

            ch.nlaps = getvalue(in, 3);
            //ch.name = lobby.stagename;
            ch.nfix = getvalue(in, 4);
            ch.notb = getvalue(in, 5) == 1;
            
            xtgraphics.nplayers = getvalue(in, 6);
            
            if (xtgraphics.im == -1) {
                xtgraphics.im = xtgraphics.nplayers - 1; //FIXED: both clients are im=0 so that causes the bindexception since they wanna be servers
                xtgraphics.sc[xtgraphics.im] = GameSparker.selectedCarStore;
                for (int j = 0; j < 6; j++) {
                    xtgraphics.allrnp[xtgraphics.im][j] = xtgraphics.arnp[j];
                }
            }
            System.out.println("IM = " + xtgraphics.im);

            int valuepoint = 0;
            for (int plrId = 0; plrId < xtgraphics.nplayers; plrId++) {
                if (plrId != xtgraphics.im) {
                    xtgraphics.sc[plrId] = getvalue(in, 7 + valuepoint);
                    for (int curCol = 0; curCol < 6; curCol++) {
                        xtgraphics.allrnp[plrId][curCol] = getvalue(in, 8 + valuepoint + curCol) / 100.0F;
                    }
                }
                valuepoint += 7;
            }
            System.out.println("ALLRNP = " + Arrays.deepToString(xtgraphics.allrnp));
            System.out.println("SC = " + Arrays.toString(xtgraphics.sc));
            
            xtgraphics.multion = 1; //0: singleplayer, 1: multiplayer, 2: watching game
            gs.u[0].multion = 1;
            xtgraphics.lan = true;
            
            xtgraphics.fase = 22;
            
            // TODO checkpoints.nlaps
            // TODO checkpoints.nfix
            // TODO checkpoints.notb
            
            /*
             * TODO
             * xt.server = xt.localserver = stuff (we already know who it is since this clientserver was created...)
             * im = hostserver's connectedClients -1?
             */
        } else {
            xtgraphics.nplayers = getvalue(in, 1);
            if (xtgraphics.im == -1) {
                xtgraphics.im = xtgraphics.nplayers - 1;
                xtgraphics.sc[xtgraphics.im] = GameSparker.selectedCarStore;
                for (int j = 0; j < 6; j++) {
                    xtgraphics.allrnp[xtgraphics.im][j] = xtgraphics.arnp[j];
                }
            }
            System.out.println("IM = " + xtgraphics.im);
            
            int valuepoint = 0;
            for (int plrId = 0; plrId < xtgraphics.nplayers; plrId++) {
                if (plrId != xtgraphics.im) {
                    xtgraphics.sc[plrId] = getvalue(in, 2 + valuepoint);
                    for (int curCol = 0; curCol < 6; curCol++) {
                        xtgraphics.allrnp[plrId][curCol] = getvalue(in, 3 + valuepoint + curCol) / 100.0F;
                    }
                }
                valuepoint += 7;
            }
            
            System.out.println("ALLRNP = " + Arrays.deepToString(xtgraphics.allrnp));
            System.out.println("SC = " + Arrays.toString(xtgraphics.sc));
        }

        return null;
    }


    public static int getvalue(final String string, final int i) {
        return HostServer.getvalue(string, i);
    }

    public static String getstring(final String string, final int i) {
        return HostServer.getstring(string, i);
    }

}
