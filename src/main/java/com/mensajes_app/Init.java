package com.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

public class Init {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        do{
            System.out.println("-----------------");
            System.out.println(" Message App ");
            System.out.println(" 1. Crear Mensaje");
            System.out.println(" 2. Listar Mensaje");
            System.out.println(" 3. Eliminar mensaje");
            System.out.println(" 4. Editar Mensaje");
            System.out.println(" 5. Salir");
            option = sc.nextInt();
            switch (option){
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    MessageService.deleteMessage();
                    break;
                case 4:
                    MessageService.editMessage();
                    break;
                default:
                    break;

            }
        }while (option!=5);
    }
}
