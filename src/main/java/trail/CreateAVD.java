package trail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateAVD {

    // Specify paths to Android SDK tools and emulator
    static String avdManagerPath = "C:\\Users\\Blubirch\\AppData\\Local\\Android\\Sdk\\cmdline-tools\\latest\\bin\\avdmanager.bat"; 
    static String emulatorPath = "C:\\Users\\Blubirch\\AppData\\Local\\Android\\Sdk\\emulator\\emulator.exe";
    static String sdkManagerPath = "C:\\Users\\Blubirch\\AppData\\Local\\Android\\Sdk\\cmdline-tools\\latest\\bin\\sdkmanager.bat";

    public static void main(String[] args) {
        try {
            // 1. Install system images (if not already installed)
            installSystemImages();

            // 2. Create an AVD using avdmanager
            createAVD("MyNewAVD", "system-images;android-30;google_apis;x86_64");

            // 3. Start the emulator
            startEmulator("MyNewAVD");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to install necessary system images via sdkmanager
    public static void installSystemImages() throws IOException {
        String[] installCommand = {sdkManagerPath, "system-images;android-30;google_apis;x86_64"};
        runCommand(installCommand);
    }

    // Function to create the AVD using avdmanager
    public static void createAVD(String avdName, String systemImagePath) throws IOException {
        String[] createAVDCommand = {
            avdManagerPath, 
            "create", 
            "avd", 
            "-n", avdName, 
            "-k", systemImagePath, 
            "--device", "pixel"
        };
        runCommand(createAVDCommand);
    }

    // Function to start the emulator for the newly created AVD
    public static void startEmulator(String avdName) throws IOException {
        String[] startEmulatorCommand = {
            emulatorPath, 
            "-avd", avdName
        };
        runCommand(startEmulatorCommand);
    }

    // Function to execute the command
    public static void runCommand(String[] command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // Read the output
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
