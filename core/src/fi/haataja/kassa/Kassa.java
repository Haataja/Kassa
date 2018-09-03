package fi.haataja.kassa;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Kassa extends Game implements ApplicationListener {
	private SpriteBatch batch;
	public BitmapFont roboto;
	public OrthographicCamera fontCamera;
	public final float WIDTH = 1422;
	public final float HEIGHT = 800;

	@Override
	public void create () {
		batch = new SpriteBatch();

        FreeTypeFontGenerator generator2 = new FreeTypeFontGenerator(Gdx.files.internal("Montserrat-ExtraBold.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter2.size = 35;
        parameter2.color = Color.BLACK;
        parameter2.borderColor = Color.WHITE;
        parameter2.borderWidth = 2;
        roboto = generator2.generateFont(parameter2);

        fontCamera = new OrthographicCamera();
        fontCamera.setToOrtho(false, 1422, 800);
        batch.setProjectionMatrix(fontCamera.combined);
        setScreen(new Tournament(this));

	}

    public SpriteBatch getBatch() {
        return batch;
    }

	@Override
	public void render () {
        super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
