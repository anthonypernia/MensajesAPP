package com.mensajes_app;

import java.util.Scanner;

public class MessageService {

    public static void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe mensaje");
        String messageText = sc.nextLine();
        System.out.println("tu nombre");
        String name = sc.nextLine();
        Message message = new Message();
        message.setMessage(messageText);
        message.setAuthor(name);
        MessageDAO.createMessageDB(message);
    }
    public static void  listMessage(){
        MessageDAO.readMessageDB();

    }
    public static void deleteMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID de mensaje a borrar = ");
        int idMessage = sc.nextInt();
        MessageDAO.deleteMessageDB(idMessage);

    }
    public static void editMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el id del mensaje");
        int idMessage = Integer.parseInt(sc.nextLine());
        System.out.println("Escribe nuevo mensaje");
        String messageUpdated = sc.nextLine();

        Message message = new Message();
        message.setIdMessage(idMessage);
        message.setMessage(messageUpdated);
        MessageDAO.updateMessageDB(message);
    }
}
