package fi.haataja.kassa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import fi.haataja.kassa.Products.ConsoleTournaments.*;
import fi.haataja.kassa.Products.MiniatureTournaments.*;
import fi.haataja.kassa.Products.Product;
import fi.haataja.kassa.Products.Ticket;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Tournament extends GestureDetector.GestureAdapter implements Screen {
    private Kassa host;
    private SpriteBatch batch;
    private Vector3 touchPos;
    private float totalTime;
    private float timeFromClick;
    private ArrayList<Product> products;
    private float sum;
    private Rectangle canteen;
    private Rectangle screen;
    private Texture screenBack;
    private Texture canteenTexture;
    private Texture ticket;
    private Texture tekken;
    private Texture meleeSingles;
    private Texture meleeDoubles;
    private Texture fourSingles;
    private Texture fourDoubles;
    private Texture ninthAge;
    private Texture hordes;
    private Texture guildBall;
    private Texture warHammer;
    private Texture bushido;
    private Texture ok;
    private Texture erase;
    private Texture ticketDraw;
    private Texture tekkenDraw;
    private Texture meleeSinglesDraw;
    private Texture meleeDoublesDraw;
    private Texture fourSinglesDraw;
    private Texture fourDoublesDraw;
    private Texture ninthAgeDraw;
    private Texture hordesDraw;
    private Texture guildBallDraw;
    private Texture warHammerDraw;
    private Texture bushidoDraw;
    private Texture okDraw;
    private Texture eraseDraw;
    private Texture ticket_1;
    private Texture tekken_1;
    private Texture meleeSingles_1;
    private Texture meleeDoubles_1;
    private Texture fourSingles_1;
    private Texture fourDoubles_1;
    private Texture ninthAge_1;
    private Texture hordes_1;
    private Texture guildBall_1;
    private Texture warhammer_1;
    private Texture bushido_1;
    private Texture ok_1;
    private Texture erase_1;
    private Rectangle ticketRec;
    private Rectangle tekkenRec;
    private Rectangle meleeSinglesRec;
    private Rectangle meleeDoublesRec;
    private Rectangle fourSinglesRec;
    private Rectangle fourDoublesRec;
    private Rectangle ninthRec;
    private Rectangle hordesRec;
    private Rectangle guildBallRec;
    private Rectangle warhammerRec;
    private Rectangle bushidoRec;
    private Rectangle okRec;
    private Rectangle eraseRec;
    ExcelWriter excelWriter;
    private Timestamp timestamp;

    public Tournament(Kassa host) {
        this.host = host;
        batch = host.getBatch();
        touchPos = new Vector3();
        sum = 0;
        excelWriter = new ExcelWriter();
        timestamp = new Timestamp((long) 0);
        canteenTexture = new Texture("Kahvio_1.png");
        canteen = new Rectangle(host.WIDTH - 4 * canteenTexture.getWidth() / 7f, host.HEIGHT - canteenTexture.getHeight() / 2f, canteenTexture.getWidth() / 2f, canteenTexture.getHeight() / 2f);
        screenBack = new Texture("back.png");
        screen = new Rectangle(0.9f * host.WIDTH - screenBack.getWidth(), host.HEIGHT / 100f, screenBack.getWidth(), host.HEIGHT - 16);

        createTextures();
        createSecondTextures();
        createRectangles();
        refreshTextures();
        products = new ArrayList<Product>();
        Gdx.input.setInputProcessor(new GestureDetector(this));
    }

    private void createRectangles() {
        ticketRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - ticket.getHeight() / 1.2f, ticket.getWidth() / 1.2f, ticket.getHeight() / 1.2f);
        tekkenRec = new Rectangle(ticketRec.x + ticketRec.width + 0.01f * host.WIDTH, host.HEIGHT - ticket.getHeight() / 1.2f, ticket.getWidth() / 1.2f, ticket.getHeight() / 1.2f);
        meleeSinglesRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 2 * meleeSingles.getHeight() / 1.2f, meleeSingles.getWidth() / 1.2f, meleeSingles.getHeight() / 1.2f);
        meleeDoublesRec = new Rectangle(ticketRec.x + ticketRec.width + 0.01f * host.WIDTH, host.HEIGHT - 2 * meleeSingles.getHeight() / 1.2f, meleeSingles.getWidth() / 1.2f, meleeSingles.getHeight() / 1.2f);
        fourSinglesRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 3 * meleeSingles.getHeight() / 1.2f, meleeSingles.getWidth() / 1.2f, meleeSingles.getHeight() / 1.2f);
        fourDoublesRec = new Rectangle(ticketRec.x + ticketRec.width + 0.01f * host.WIDTH, host.HEIGHT - 3 * meleeSingles.getHeight() / 1.2f, meleeSingles.getWidth() / 1.2f, meleeSingles.getHeight() / 1.2f);
        ninthRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 4 * meleeSingles.getHeight() / 1.2f, meleeSingles.getWidth() / 1.2f, meleeSingles.getHeight() / 1.2f);
        hordesRec = new Rectangle(ticketRec.x + ticketRec.width + 0.01f * host.WIDTH, host.HEIGHT - 4 * meleeSingles.getHeight() / 1.2f, meleeSingles.getWidth() / 1.2f, meleeSingles.getHeight() / 1.2f);
        guildBallRec = new Rectangle(0.01f * host.WIDTH + ticketRec.width / 2f + 0.01f * host.WIDTH, host.HEIGHT - 5 * meleeSingles.getHeight() / 1.2f, meleeSingles.getWidth() / 1.2f, meleeSingles.getHeight() / 1.2f);
        warhammerRec = new Rectangle(ticketRec.x + ticketRec.width + 0.01f * host.WIDTH, host.HEIGHT - 6 * meleeSingles.getHeight() / 1.2f, meleeSingles.getWidth() / 1.2f, meleeSingles.getHeight() / 1.2f);
        bushidoRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 6 * meleeSingles.getHeight() / 1.2f, meleeSingles.getWidth() / 1.2f, meleeSingles.getHeight() / 1.2f);
        okRec = new Rectangle(screen.x + 3 * screen.width / 7f - ok.getWidth() / 1.7f, screen.y + 0.0125f * screen.height, ok.getWidth() / 1.7f, ok.getHeight() / 1.7f);
        eraseRec = new Rectangle(okRec.x - erase.getWidth() / 1.7f, okRec.y, erase.getWidth() / 1.7f, erase.getHeight() / 1.7f);
    }

    private void createTextures() {
        ticket = new Texture("Lippu_1.png");
        meleeSingles = new Texture("Melee_Singles_1.png");
        meleeDoubles = new Texture("Melee_Doubles_1.png");
        fourSingles = new Texture("4_Singles_1.png");
        fourDoubles = new Texture("4_Doubles_1.png");
        tekken = new Texture("Tekken_1.png");
        ninthAge = new Texture("9th_age_1.png");
        hordes = new Texture("Hordes_1.png");
        guildBall = new Texture("Guild_Ball_1.png");
        warHammer = new Texture("Warhammer_1.png");
        bushido = new Texture("Bushido_1.png");
        ok = new Texture("ok_1.png");
        erase = new Texture("poista_1.png");
    }

    private void createSecondTextures() {
        ticket_1 = new Texture("Lippu_2.png");
        meleeSingles_1 = new Texture("Melee_Singles_2.png");
        meleeDoubles_1 = new Texture("Melee_Doubles_2.png");
        fourSingles_1 = new Texture("4_Singles_2.png");
        fourDoubles_1 = new Texture("4_Doubles_2.png");
        tekken_1 = new Texture("Tekken_2.png");
        ninthAge_1 = new Texture("9th_age_2.png");
        hordes_1 = new Texture("Hordes_2.png");
        guildBall_1 = new Texture("Guild_Ball_2.png");
        warhammer_1 = new Texture("Warhammer_2.png");
        bushido_1 = new Texture("Bushido_2.png");
        ok_1 = new Texture("ok_2.png");
        erase_1 = new Texture("poista_2.png");
    }

    public void refreshTextures() {
        ticketDraw = ticket;
        tekkenDraw = tekken;
        meleeSinglesDraw = meleeSingles;
        meleeDoublesDraw = meleeDoubles;
        fourSinglesDraw = fourSingles;
        fourDoublesDraw = fourDoubles;
        ninthAgeDraw = ninthAge;
        hordesDraw = hordes;
        guildBallDraw = guildBall;
        warHammerDraw = warHammer;
        bushidoDraw = bushido;
        okDraw = ok;
        eraseDraw = erase;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        totalTime += delta;
        timestamp.setTime(System.currentTimeMillis());

        if (canteen.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            host.setScreen(new Cafeteria(host));
        }

        if (ticketRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            ticketDraw = ticket_1;
            Product product = new Ticket(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (tekkenRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            tekkenDraw = tekken_1;
            Product product = new Tekken(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (meleeSinglesRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            meleeSinglesDraw = meleeSingles_1;
            Product product = new MeleeSingles(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (meleeDoublesRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            meleeDoublesDraw = meleeDoubles_1;
            Product product = new MeleeDoubles(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (fourSinglesRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            fourSinglesDraw = fourSingles_1;
            Product product = new FourSingles(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (fourDoublesRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            fourDoublesDraw = fourDoubles_1;
            Product product = new FourDoubles(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (ninthRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            ninthAgeDraw = ninthAge_1;
            Product product = new NinthAge(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (hordesRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            hordesDraw = hordes_1;
            Product product = new Hordes(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (guildBallRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            guildBallDraw = guildBall_1;
            Product product = new GuildBall(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (warhammerRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            warHammerDraw = warhammer_1;
            Product product = new Warhammer(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (bushidoRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            bushidoDraw = bushido_1;
            Product product = new Bushido(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if (okRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            okDraw = ok_1;
            for(Product product: products){
                try {
                    excelWriter.write(product);
                } catch (InvalidFormatException e){
                    Gdx.app.log("ERROR","error while writing to exel" + e);
                } catch (IOException e){
                    Gdx.app.log("ERROR","error while writing to exel" + e);
                }
            }
            products.clear();
            sum = 0;
        }
        if (eraseRec.contains(touchPos.x, touchPos.y)) {
            touchPos.x = 0;
            touchPos.y = 0;
            eraseDraw = erase_1;
            if (products.size() > 0) {
                int index = products.size() - 1;
                sum -= products.get(index).getPrice();
                products.remove(index);
            }
        }

        batch.begin();
        batch.draw(canteenTexture, canteen.x, canteen.y, canteen.width, canteen.height);
        batch.draw(screenBack, screen.x, screen.y, screen.width, screen.height);
        batch.draw(ticketDraw, ticketRec.x, ticketRec.y, ticketRec.width, ticketRec.height);
        batch.draw(tekkenDraw, tekkenRec.x, tekkenRec.y, tekkenRec.width, tekkenRec.height);
        batch.draw(meleeSinglesDraw, meleeSinglesRec.x, meleeSinglesRec.y, meleeSinglesRec.width, meleeSinglesRec.height);
        batch.draw(meleeDoublesDraw, meleeDoublesRec.x, meleeDoublesRec.y, meleeDoublesRec.width, meleeDoublesRec.height);
        batch.draw(fourSinglesDraw, fourSinglesRec.x, fourSinglesRec.y, fourSinglesRec.width, fourSinglesRec.height);
        batch.draw(fourDoublesDraw, fourDoublesRec.x, fourDoublesRec.y, fourDoublesRec.width, fourDoublesRec.height);
        batch.draw(ninthAgeDraw, ninthRec.x, ninthRec.y, ninthRec.width, ninthRec.height);
        batch.draw(hordesDraw, hordesRec.x, hordesRec.y, hordesRec.width, hordesRec.height);
        batch.draw(guildBallDraw, guildBallRec.x, guildBallRec.y, guildBallRec.width, guildBallRec.height);
        batch.draw(warHammerDraw, warhammerRec.x, warhammerRec.y, warhammerRec.width, warhammerRec.height);
        batch.draw(bushidoDraw, bushidoRec.x, bushidoRec.y, bushidoRec.width, bushidoRec.height);
        drawProducts();
        host.roboto.draw(batch, "Yhteensä: " + sum + "€", screen.x + 3 * screen.width / 7f, screen.y + screen.height / 15f);
        batch.draw(okDraw, okRec.x, okRec.y, okRec.width, okRec.height);
        batch.draw(eraseDraw, eraseRec.x, eraseRec.y, eraseRec.width, eraseRec.height);
        batch.end();

        if (totalTime - timeFromClick > 0.25f) {
            refreshTextures();
        }
    }

    public void drawProducts() {
        for (int i = 0; i < products.size(); i++) {
            host.roboto.draw(batch, products.get(i).getName(), screen.x + screen.width / 40f, screen.y + screen.getHeight() - (i + 1) * screen.getHeight() / 15);
            host.roboto.draw(batch, products.get(i).toString(), screen.x + 15*screen.width / 20f, screen.y + screen.getHeight() - (i + 1) * screen.getHeight() / 15);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        touchPos = new Vector3(x, y, 0);
        host.fontCamera.unproject(touchPos);
        timeFromClick = totalTime;
        Gdx.app.log("TAP", "x: " + touchPos.x + " y: " + touchPos.y);
        return true;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        canteenTexture.dispose();
        screenBack.dispose();
        ticket.dispose();
        tekken.dispose();
        meleeSingles.dispose();
        meleeDoubles.dispose();
        fourDoubles.dispose();
        fourSingles.dispose();
        ninthAge.dispose();
        guildBall.dispose();
        hordes.dispose();
        bushido.dispose();
        warHammer.dispose();
        ticket_1.dispose();
        tekken_1.dispose();
        meleeSingles_1.dispose();
        meleeDoubles_1.dispose();
        fourDoubles_1.dispose();
        fourSingles_1.dispose();
        ninthAge_1.dispose();
        guildBall_1.dispose();
        hordes_1.dispose();
        bushido_1.dispose();
        warhammer_1.dispose();
    }
}
