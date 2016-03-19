

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class HostServer implements Runnable {

    static final int NOTIFY_LISTEN_PORT = 7100;
    static final int SERVER_PORT = 7251;

    InetAddress[] IPAddress = new InetAddress[3];
    DatagramSocket[] dSocket = new DatagramSocket[3];
    int[] serverdone = {
            -1, -1, -1
    };
    long[] servestart = {
            0L, 0L, 0L
    };

    int port;

    public HostServer(final int port, final int maxPlayers) {
        this.port = port;
        this.maxPlayers = maxPlayers;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        System.out.println("running");
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("made a socket in port " + port);
            while (true) {
                final Socket clientSocket = serverSocket.accept();
                final PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine, outputLine;

                // Initiate conversation with client
                //outputLine = kkp.processInput(null);
                //out.println(outputLine);

                while ((inputLine = in.readLine()) != null) {
                    outputLine = processInput(inputLine);
                    out.println(outputLine);
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

    private int maxPlayers = 8;
    private short[][] clientIPs = new short[maxPlayers][4]; //using bytes was a stupid idea but no turning back now
    private int[] clientPorts = new int[maxPlayers];
    private int[] clientCars = new int[maxPlayers];
    private int[][] clientCarColors = new int[maxPlayers][6]; 
    private int connectedClients = 0;
    private Socket clientNotifier;
    private BufferedReader din;
    private PrintWriter dout;

    private int gameStage = 1;
    private int gameLaps = 10;
    private int gameFixes = 5;
    private int gameNoTreesOrBumps = 0;

    /**
     * Format...
     *
     * connect:
     * 192.168.0.1:7100 (ip:port)|0 (car)|arnp[0]|arnp[1]|arnp[2]|arnp[3]|arnp[4]|arnp[5]|
     *
     * notify:
     *   when started: start|1 (stage)|5 (laps)|5 (fixes)|0/1 (notb)|
     *   7 (num of players)|
     *   for every player:
     *     0 (car)|arnp[0]|arnp[1]|arnp[2]|arnp[3]|arnp[4]|arnp[5]|
     *
     *
     */
    public String processInput(final String s) { //TODO shutdown server after game starts (since it moves to UDP)
                                                 //TODO change xt.servport, idk if it needs to equal this server's port

        System.out.println("teh data is " + s);
        
        String preipS = getstring(s,1);
        String ipish = preipS.substring(0, preipS.indexOf(":"));
        int port = Integer.parseInt(preipS.substring(preipS.indexOf(":") + 1, preipS.length()));
        
        String[] ipAddr = ipish.split("\\.");
                
        System.out.println("teh ip is " + Arrays.toString(ipAddr));
        for (int i = 0; i < 4; i++) {
            clientIPs[connectedClients][i] = Short.parseShort(ipAddr[i])/*(byte) (Integer.parseInt(ipAddr[i]) & 0xFF)*/; //(byte) (Integer.parseInt(quarter) & 0xFF)
        }
        clientPorts[connectedClients] = port;
        System.out.println("teh ip is 2 " + Arrays.toString(clientIPs[connectedClients]));
        clientCars[connectedClients] = getvalue(s,2);
        for (int i = 0; i < 6; i++)
            clientCarColors[connectedClients][i] = getvalue(s,3 + i);

        connectedClients++;

        for (int i = 0; i < connectedClients; i++) {
            try {
                //if (i != connectedClients - 1) {//is not this client
                    String ip = clientIPs[i][0] + "." + clientIPs[i][1] + "." + clientIPs[i][2] + "." + clientIPs[i][3];
                    clientNotifier = new Socket(ip, clientPorts[i]); //notify port is 7000
                    System.out.println("notifying to client at " + ip + ":" + clientPorts[i]);
                    din = new BufferedReader(new InputStreamReader(clientNotifier.getInputStream()));
                    dout = new PrintWriter(clientNotifier.getOutputStream(), true);

                    StringBuilder output = new StringBuilder();
                    if (connectedClients >= maxPlayers) {
                        output.append("start|" + gameStage + "|");
                        
                        output.append(gameLaps + "|"); //yes, only on game start
                        output.append(gameFixes + "|");
                        output.append(gameNoTreesOrBumps + "|");
                    }
                    output.append(connectedClients + "|");
                    for (int j = 0; j < connectedClients; j++) {
                        output.append(clientCars[j] + "|");
                        // car colors
                        output.append((int) (clientCarColors[j][0]) + "|" + (int) (clientCarColors[j][1]) + "|" + (int) (clientCarColors[j][2]) + "|" + (int) (clientCarColors[j][3]) + "|" + (int) (clientCarColors[j][4]) + "|" + (int) (clientCarColors[j][5]) + "|");
                    }


                    dout.println(output.toString());


                    closeSockets();
                //}
            } catch (IOException e) {
                System.err.println("Failed to notify client id " + i);
                e.printStackTrace();
            }
        }

        StringBuilder output = new StringBuilder(connectedClients + "|");
        for (int j = 0; j < connectedClients - 1; j++) { // not this client
            output.append(clientCars[j] + "|");
        }

        // FIXME
        // ignore this
        if (connectedClients >= maxPlayers) { //THE CURRENT PROBLEM: the client doesn't seem to be receiving this data or is ignoring it. is there a way to make it receive it without another socket?
            return "start|" + gameStage + "|" + output.toString();
        } else {
            return "" + output.toString();
        }
    }

    private void closeSockets() throws IOException {
        clientNotifier.close();
        din.close();
        dout.flush();
        dout.close();
        clientNotifier = null;
        din = null;
        dout = null;
    }

    public static int getvalue(final String string, final int i) {
        return Integer.parseInt(getstring(string, i));
    }

    public static String getstring(final String string, int i) {
        i -= 1; //fuckfuckfuckfuck i did it all wrong it was supposed to start from 0
        String s = null;
        try {
            int i_69_ = 0;
            int i_70_ = 0;
            int i_71_ = 0;
            String string_72_ = "";
            String cur_str = "";
            for (/**/; i_69_ < string.length() && i_71_ != 2; i_69_++) {
                string_72_ = new StringBuilder().append("").append(string.charAt(i_69_)).toString();
                if (string_72_.equals("|")) {
                    i_70_++;
                    if (i_71_ == 1 || i_70_ > i)
                        i_71_ = 2;
                } else if (i_70_ == i) {
                    cur_str = new StringBuilder().append(cur_str).append(string_72_).toString();
                    i_71_ = 1;
                }
            }
            if (cur_str.equals(""))
                cur_str = null;
            s = cur_str;
        } catch (final Exception exception) {
            /* empty */
        }
        return s;
    }

    //
}
