package core.Room;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import core.Element.Wall;

public class BuildingC extends Game {
    World world;
    OrthographicCamera camera;
    Box2DDebugRenderer debugRenderer;

    @Override
    public void create() {
        world = new World(new Vector2(0, 0), true);
        camera = new OrthographicCamera(100, 50);
        debugRenderer = new Box2DDebugRenderer();

        float scale = 1.0f;
        float moveX = -16f;
        float moveY = -16f;

        float doorWidth = 2f;
        float halfDoorWidth = doorWidth/2;

        Wall wallAR = new Wall();
        Wall wallBR_L = new Wall();
        Wall wallBR_P = new Wall();
        Wall wallCR_L = new Wall();
        Wall wallCR_P = new Wall();
        Wall wallDR = new Wall();


        wallAR.createWall(0f, 0f, 32f, 0f, world, scale, moveX, moveY);
        wallBR_L.createWall(0f, 12f, 24f-halfDoorWidth, 12f, world, scale, moveX, moveY);
        wallBR_P.createWall(24f+halfDoorWidth, 12f, 32f, 12f, world, scale, moveX, moveY);
        wallCR_L.createWall(0f, 20f, 8f-halfDoorWidth, 20f, world, scale, moveX, moveY);
        wallCR_P.createWall(8f+halfDoorWidth, 20f, 32f, 20f, world, scale, moveX, moveY);
        wallDR.createWall(0f, 32f, 32f, 32f, world, scale, moveX, moveY);

        Wall wallAP_T = new Wall();
        Wall wallAP_B = new Wall();
        Wall wallBP_T = new Wall();
        Wall wallBP_B = new Wall();
        Wall wallCP_T = new Wall();
        Wall wallCP_B = new Wall();
        Wall wallDP_T = new Wall();
        Wall wallDP_B = new Wall();

        wallAP_T.createWall(0f, 16f+halfDoorWidth, 0f, 32f, world, scale, moveX, moveY);
        wallAP_B.createWall(0f, 0f, 0f, 16f-halfDoorWidth, world, scale, moveX, moveY);
        wallBP_T.createWall(32f, 16f+halfDoorWidth, 32f, 32f, world, scale, moveX, moveY);
        wallBP_B.createWall(32f, 0f, 32f, 16f-halfDoorWidth, world, scale, moveX, moveY);
        wallCP_T.createWall(16f, 26f+halfDoorWidth, 16f, 32f, world, scale, moveX, moveY);
        wallCP_B.createWall(16f, 20f, 16f, 26f-halfDoorWidth, world, scale, moveX, moveY);
        wallDP_T.createWall(16f, 6f+halfDoorWidth, 16f, 12f, world, scale, moveX, moveY);
        wallDP_B.createWall(16f, 0f, 16f, 6f-halfDoorWidth, world, scale, moveX, moveY);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.125f, .125f, .125f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        debugRenderer.render(world, camera.combined); // render all your graphics before you do your physics step, so it won't be out of sync
        world.step(1 / 60f, 6, 2);
    }

    @Override
    public void dispose () {
        world.dispose();
        debugRenderer.dispose();
    }
}