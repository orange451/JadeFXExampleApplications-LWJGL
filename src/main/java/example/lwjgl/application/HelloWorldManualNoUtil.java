package example.lwjgl.application;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

import io.jadefx.JadeFX;
import io.jadefx.scene.control.Label;
import io.jadefx.stage.Stage;

public class HelloWorldManualNoUtil {
	public static void main(String[] args) {
		
		// Start GLFW
		if (!GLFW.glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");
		
		// Window Hints
		GLFW.glfwDefaultWindowHints();
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GL11.GL_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GL11.GL_TRUE);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 2);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GL11.GL_TRUE);
		long win = GLFW.glfwCreateWindow(640, 480, "Hello World Manual", MemoryUtil.NULL, MemoryUtil.NULL);
		
		// Create Window
		if ( win == MemoryUtil.NULL )
			throw new RuntimeException("Failed to create the GLFW window");

		// Setup Context
		GLFW.glfwMakeContextCurrent(win);
		GLFW.glfwSwapInterval(1);
		GL.createCapabilities();
		
		// Create Stage
		Stage stage = JadeFX.create(win);
		stage.getScene().setRoot(new Label("Hello World"));
		
		// Display
		stage.show();

		// Render loop
        while (!GLFW.glfwWindowShouldClose(win)) {
        	JadeFX.render();
        }
        
        // Cleanup
        GLFW.glfwTerminate();
    }
}
