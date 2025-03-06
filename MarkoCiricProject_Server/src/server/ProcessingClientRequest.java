/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import operations.Operations;
import transfer.ClientRequest;
import transfer.ServerResponse;
import util.NarucilacUsluge;
import util.Otpremnica;
import util.Roba;
import util.StavkaOtpremnice;
import util.Vozac;
import util.VrstaVozaca;
import util.VzVV;

/**
 *
 * @author Marko
 */
public class ProcessingClientRequest extends Thread {

    private Socket s;

    public ProcessingClientRequest(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ClientRequest clientRequest = getRequest();
                ServerResponse serverResponse = new ServerResponse();
                ObjectMapper objectMapper = new ObjectMapper();
                String json;
                Roba r;
                NarucilacUsluge nu;
                Vozac v;
                VzVV vzvv;
                Otpremnica o;
                HashMap<Integer, String> map;
                int delete;
                int pom;
                switch (clientRequest.getOperation()) {
                    case getListVozac:
                        List<Vozac> list = Controller.getInstance().getListVozac();
                        serverResponse.setResponse(list);
                        break;
                    case updateVozac:
                        json = (String) clientRequest.getParam();
                        v = objectMapper.readValue(json, Vozac.class);
                        serverResponse.setResponse(Controller.getInstance().updateVozac(v));
                        break;
                    case deleteVozac:
                        json = (String) clientRequest.getParam();
                        delete = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().deleteVozac(delete));
                        break;
                    case getListOtpremnica:
                        serverResponse.setResponse(Controller.getInstance().getListOtpremnica());
                        break;
                    case getVehicles:
                        json = (String) clientRequest.getParam();
                        pom = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().getVehicles(pom));
                        break;
                    case getListVzVV:
                        json = (String) clientRequest.getParam();
                        pom = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().getListVzVV(pom));
                        break;
                    case deleteOtpremnica:
                        json = (String) clientRequest.getParam();
                        o = objectMapper.readValue(json, Otpremnica.class);
                        serverResponse.setResponse(Controller.getInstance().deleteOtpremnica(o));
                        break;
                    case insertVozac:
                        json = (String) clientRequest.getParam();
                        v = objectMapper.readValue(json, Vozac.class);
                        serverResponse.setResponse(Controller.getInstance().insertVozac(v));
                        break;
                    case getListVrstaVozaca:
                        serverResponse.setResponse(Controller.getInstance().getListVrstaVozaca());
                        break;
                    case updateVzVV:
                        json = (String) clientRequest.getParam();
                        vzvv = objectMapper.readValue(json, VzVV.class);
                        serverResponse.setResponse(Controller.getInstance().updateVzVV(vzvv));
                        break;
                    case deleteVzVV:
                        json = (String) clientRequest.getParam();
                        delete = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().deleteVzVV(delete));
                        break;
                    case insertVzVV:
                        json = (String) clientRequest.getParam();
                        vzvv = objectMapper.readValue(json, VzVV.class);
                        serverResponse.setResponse(Controller.getInstance().insertVzVV(vzvv));
                        break;
                    case deleteVrstaVozaca:
                        int vzvv2 = (int) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().deleteVrstaVozaca(vzvv2));
                        break;
                    case insertVrstaVozaca:
                        VrstaVozaca vv1 = (VrstaVozaca) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().insertVrstaVozaca(vv1));
                        break;
                    case getListRoba:
                         map = (HashMap<Integer, String>) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().getListRoba(map));
                        break;
                    case deleteRoba:
                        json = (String) clientRequest.getParam();
                        delete = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().deleteRoba(delete));
                        break;
                    case updateRoba:
                        json = (String) clientRequest.getParam();
                        r = objectMapper.readValue(json, Roba.class);
                        serverResponse.setResponse(Controller.getInstance().updateRoba(r));
                        break;
                    case insertRoba:
                        json = (String) clientRequest.getParam();
                        r = objectMapper.readValue(json, Roba.class);
                        serverResponse.setResponse(Controller.getInstance().insertRoba(r));
                        break;
                    case getListNarucilacUsluge:
                         map = (HashMap<Integer, String>) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().getListNarucilacUsluge(map));
                        break;
                    case getListStavkeOtpremnice:
                        int so = (int) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().getListStavkeOtpremnice(so));
                        break;
                    case sumPrices:
                        int o1 = (int) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().sumPrices(o1));
                        break;
                    case getVzVV:
                        json = (String) clientRequest.getParam();
                        VzVV vzvv5 = objectMapper.readValue(json, VzVV.class);
                        serverResponse.setResponse(Controller.getInstance().getVzVV(vzvv5));
                        break;
                    case getListMesto:
                        serverResponse.setResponse(Controller.getInstance().getListMesto());
                        break;
                    case updateQtySO:
                        StavkaOtpremnice so1 = (StavkaOtpremnice) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().updateStavkaOtpremnice(so1));
                        break;
                    case insertStavkaOtpremnice:
                        StavkaOtpremnice so2 = (StavkaOtpremnice) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().insertStavkaOtpremnice(so2));
                        break;
                    case deleteStavkaOtpremnice:
                        int so3 = (int) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().deleteStavkaOtpremnice(so3));
                        break;
                    case updateOtpremnica:
                        List<Object> list2 = (List<Object>) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().updateOtpremnica(list2));
                        break;
                    case updateNarucilacUsluge:
                        json = (String) clientRequest.getParam();
                        nu = objectMapper.readValue(json, NarucilacUsluge.class);
                        serverResponse.setResponse(Controller.getInstance().updateNarucilacUsluge(nu));
                        break;
                    case insertNarucilacUsluge:
                        json = (String) clientRequest.getParam();
                        nu = objectMapper.readValue(json, NarucilacUsluge.class);
                        serverResponse.setResponse(Controller.getInstance().insertNarucilacUsluge(nu));
                        break;
                    case insertOtpremnica:
                        Otpremnica o3 = (Otpremnica) clientRequest.getParam();
                        serverResponse.setResponse(Controller.getInstance().insertOtpremnica(o3));
                        break;
                    case deleteNarucilacUsluge:
                        json = (String) clientRequest.getParam();
                        delete = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().deleteNarucilacUsluge(delete));
                        break;
                    case userLogged:
                        json = (String) clientRequest.getParam();
                        v = objectMapper.readValue(json, Vozac.class);
                        Controller.getInstance().userLogged(v);
                        break;
                    case getListLogged:
                        serverResponse.setResponse(Controller.getInstance().getListLogged());
                        break;
                    case userLogout:
                        json = (String) clientRequest.getParam();
                        v = objectMapper.readValue(json, Vozac.class);
                        Controller.getInstance().userLogout(v);
                        break;
                    case checkConnection:
                        StartServer server = new StartServer();
                        serverResponse.setResponse(server.isClosed());
                        break;
                    default:
                        System.out.println("greska");
                    //ovde izlistati operacije koje klijent moze da izvrsi
                }

                sendResponse(serverResponse);
            } catch (Exception ex) {
                Logger.getLogger(ProcessingClientRequest.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
    }

    private ClientRequest getRequest() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(s.getInputStream());
            return (ClientRequest) inputStream.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Greska");
        }
        return null;
    }

    private void sendResponse(ServerResponse response) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
            outputStream.writeObject(response);
            outputStream.flush();
        } catch (IOException ex) {
            System.out.println("Greska");
        }
    }

}
