package example.lwjgl.application;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import io.jadefx.JadeFX;
import io.jadefx.scene.control.Label;
import io.jadefx.stage.Stage;
import io.jadefx.util.JadeFXUtil;

public class HelloWorldManual {
	public static void main(String[] args) {
		
		// Start GLFW
		if (!GLFW.glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");
		
		// Create Window
		long win = JadeFXUtil.createWindowGLFW(640, 480, "Window");
		if ( win == MemoryUtil.NULL )
			throw new RuntimeException("Failed to create the GLFW window");

		// Setup OpenGL
		GLFW.glfwMakeContextCurrent(win);
		GLFW.glfwSwapInterval(1);
		GL.createCapabilities();
		
		// Create and show Stage
		Stage stage = JadeFX.create(win);
		stage.show();
		
		// Add label
		stage.getScene().setRoot(new Label("Hello World"));

		// Render loop
        while (!GLFW.glfwWindowShouldClose(win)) {
        	JadeFX.render();
        }
        
        // Cleanup
        GLFW.glfwTerminate();
    }
}
