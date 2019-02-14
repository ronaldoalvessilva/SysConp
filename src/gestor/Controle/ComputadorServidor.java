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
 * @author Socializa TI 02
 */
public class ComputadorServidor {

    private static final long serialVersionUID = 1L;
   
    public String getHostName() {
        try {
            return InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public String getUserName() {
        return System.getProperty("user.name");
    }

    public String getSO() {
        return System.getProperty("os.name");     
    }

    public String getArchitecture() {
        return System.getProperty("os.arch");
    }

    public String getOSVersion() {
        return System.getProperty("os.version");
    }
}
