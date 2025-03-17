/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import com.fasterxml.jackson.core.type.TypeReference;
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
    private StartServer server;

    public ProcessingClientRequest(Socket s, StartServer server) {
        this.s = s;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ClientRequest clientRequest = getRequest();
                ServerResponse serverResponse = new ServerResponse();
                ObjectMapper objectMapper = new ObjectMapper();
                String json;
                Roba r;
                NarucilacUsluge nu;
                Vozac v;
                VzVV vzvv;
                VrstaVozaca vv;
                Otpremnica o;
                StavkaOtpremnice so;
                HashMap<Integer, String> map;
                int delete;
                int pom;
                switch (clientRequest.getOperation()) {
                    case getListVozac:
                        serverResponse.setResponse(Controller.getInstance().getListVozac());
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
                        json = (String) clientRequest.getParam();
                        delete = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().deleteVrstaVozaca(delete));
                        break;
                    case insertVrstaVozaca:
                        json = (String) clientRequest.getParam();
                        vv = objectMapper.readValue(json, VrstaVozaca.class);
                        serverResponse.setResponse(Controller.getInstance().insertVrstaVozaca(vv));
                        break;
                    case getListRoba:
                        json = (String) clientRequest.getParam();
                        map = objectMapper.readValue(json, new TypeReference<HashMap<Integer, String>>() {
                        });
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
                        json = (String) clientRequest.getParam();
                        map = objectMapper.readValue(json, new TypeReference<HashMap<Integer, String>>() {
                        });
                        serverResponse.setResponse(Controller.getInstance().getListNarucilacUsluge(map));
                        break;
                    case getListStavkeOtpremnice:
                        json = (String) clientRequest.getParam();
                        pom = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().getListStavkeOtpremnice(pom));
                        break;
                    case sumPrices:
                        json = (String) clientRequest.getParam();
                        pom = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().sumPrices(pom));
                        break;
                    case getVzVV:
                        json = (String) clientRequest.getParam();
                        vzvv = objectMapper.readValue(json, VzVV.class);
                        serverResponse.setResponse(Controller.getInstance().getVzVV(vzvv));
                        break;
                    case getListMesto:
                        serverResponse.setResponse(Controller.getInstance().getListMesto());
                        break;
                    case insertStavkaOtpremnice:
                        json = (String) clientRequest.getParam();
                        so = objectMapper.readValue(json, StavkaOtpremnice.class);
                        serverResponse.setResponse(Controller.getInstance().insertStavkaOtpremnice(so));
                        break;
                    case deleteStavkaOtpremnice:
                        json = (String) clientRequest.getParam();
                        delete = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().deleteStavkaOtpremnice(delete));
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
                        json = (String) clientRequest.getParam();
                        o = objectMapper.readValue(json, Otpremnica.class);
                        serverResponse.setResponse(Controller.getInstance().insertOtpremnica(o));
                        break;
                    case deleteNarucilacUsluge:
                        json = (String) clientRequest.getParam();
                        delete = objectMapper.readValue(json, Integer.class);
                        serverResponse.setResponse(Controller.getInstance().deleteNarucilacUsluge(delete));
                        break;
                    case getListLogged:
                        serverResponse.setResponse(Controller.getInstance().getListLogged());
                        break;
                    case userLogout:
                        json = (String) clientRequest.getParam();
                        v = objectMapper.readValue(json, Vozac.class);
                        Controller.getInstance().userLogout(v);
                        break;
                    case login:
                        json = (String) clientRequest.getParam();
                        List<String> params = objectMapper.readValue(json, List.class);
                        String email = params.get(0);
                        String password = params.get(1);
                        serverResponse.setResponse(Controller.getInstance().login(email, password));
                        break;
                    default:
                        System.out.println("greska");
                    //ovde izlistati operacije koje klijent moze da izvrsi
                }

                sendResponse(serverResponse);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Klijent je prekinuo konekciju: " + s);
        } catch (Exception ex) {
            Logger.getLogger(ProcessingClientRequest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (s != null && !s.isClosed()) {
                    s.close();
                }
            } catch (IOException e) {
                Logger.getLogger(ProcessingClientRequest.class.getName()).log(Level.SEVERE, null, e);
            }

            // Ukloni klijenta iz liste aktivnih klijenata
            synchronized (server.getActiveClients()) {
                server.getActiveClients().remove(s);
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
