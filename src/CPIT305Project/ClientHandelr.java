// Group Names:
// Shuruq Baabdullah 1906284 VBR
// Rahaf Dawoud 1911088 VBR
// Elaf Yousef Aloufi 1911265
// Manar Mutlaq Altaiary 1906775
package CPIT305Project;

import static CPIT305Project.clientChat.din;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandelr extends Thread {

    private Socket socket;
    private DataInputStream din;
    private DataOutputStream dout;
    private ArrayList<String> receivemsg = new ArrayList<>();

    public ClientHandelr(Socket socket) throws IOException {
        this.socket = socket;
        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());

    }

    @Override
    public void run() {
        try {
            String msg;
            while (true) {
                msg = din.readUTF();
                synchronized (receivemsg) {
                    receivemsg.add(msg);
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        try {
            if (dout != null) {
                dout.close();
            }
            if (din != null) {
                din.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void sendmsg(String str) {
        try {
            dout.writeUTF(str);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<String> getReceivemsg() {
        return receivemsg;
    }

}
