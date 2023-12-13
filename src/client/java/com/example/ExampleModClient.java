package com.example;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import java.net.URL;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		getRelease();
	}

	public static void getRelease() {
		String minecraftDir = FabricLoader.getInstance().getGameDir().resolve("resourcepacks").toString();
		String githubRepoUrl = "https://raw.githubusercontent.com/Picaban12/peaky-blinders/master/DREAM.zip";

		try {
			URL url = new URL(githubRepoUrl);
			InputStream in = url.openStream();
			Files.copy(in, Paths.get(minecraftDir + "/DREAM.zip"));
			in.close();
			System.out.println("Latest release downloaded successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}