package MP3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a song to play:");
            System.out.println("1. PANTROPIKO");
            System.out.println("2. KARERA");
            System.out.println("3. SALAMIN");
            System.out.print("Enter your choice (1, 2, or 3): ");
            
            try {
                int choice = scanner.nextInt();
                
                if (choice >= 1 && choice <= 3) {
                    playSong(choice);
                    break; // Exit loop after playing the selected song
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close();
    }

    private static void playSong(int choice) {
        MediaPlayer mediaPlayer;
        
        switch (choice) {
            case 1:
                mediaPlayer = new Pantropiko();
                mediaPlayer.play("C:\\Users\\user\\Music for Assignment Code\\PANTROPIKO.mp3");
                break;
            case 2:
                mediaPlayer = new Karera();
                mediaPlayer.play("C:\\Users\\user\\Music for Assignment Code\\KARERA.mp3");
                break;
            case 3:
                mediaPlayer = new Salamin();
                mediaPlayer.play("C:\\Users\\user\\Music for Assignment Code\\SALAMIN.mp3");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
    }
}
