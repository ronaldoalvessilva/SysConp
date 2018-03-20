/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Ronaldo
 */
public class GetLocalHost {

    public static String hostName;
    public static String ipHost;

//    public static void main(String[] args) throws UnknownHostException {
    public static void obterHostNameIpHost(String ip, String nome) throws UnknownHostException {
        InetAddress myself = InetAddress.getLocalHost();
        ipHost = myself.getHostAddress();
        hostName = myself.getHostName();
        System.out.println("O ip do Host é :" + ipHost + "  E o nome do Host é:" + hostName);
    }
}
