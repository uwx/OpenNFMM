import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer implements Runnable {

    InetAddress[] IPAddress = new InetAddress[3];
    DatagramSocket[] dSocket = new DatagramSocket[3];
    int[] serverdone = {
            -1, -1, -1
    };
    long[] servestart = {
            0L, 0L, 0L
    };

    public static void main(final String[] args) throws IOException {

        // login
        /*int portNumber = 7061;
        Thread t = new Thread(new HostServer(portNumber));
        t.start();

        portNumber = 7067;
        t = new Thread(new HostServer(portNumber));
        t.start();*/

    }

    int port;
    private GameSparker gs;
    private CheckPoints ch;
    static Object threadLock = new Object();

    public ClientServer(xtGraphics xtgraphics, GameSparker gs, CheckPoints ch) {
        this.port = HostServer.NOTIFY_LISTEN_PORT;
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
            xtgraphics.nplayers = getvalue(in, 3);

            xtgraphics.fase = 22;
            /*
             * TODO
             * xt.server = xt.localserver = stuff (we already know who it is since this clientserver was created...)
             * im = hostserver's connectedClients -1?
             */
        } else {
            xtgraphics.nplayers = getvalue(in, 1);
            if (xtgraphics.im == -1)
                xtgraphics.im = xtgraphics.nplayers;
            for (int i = 0; i < xtgraphics.nplayers; i++) {
                if (i != xtgraphics.im)
                /*    xtgraphics.sc[0] = getvalue(in, 2 + i);
                else*/
                    xtgraphics.sc[i + 1] = getvalue(in, 2 + i);
            }
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
