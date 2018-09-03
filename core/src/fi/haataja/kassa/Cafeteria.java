package fi.haataja.kassa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import fi.haataja.kassa.Products.Cafeteria.*;
import fi.haataja.kassa.Products.Product;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Cafeteria extends GestureDetector.GestureAdapter implements Screen {
    private Kassa host;
    private SpriteBatch batch;
    private Vector3 touchPos;
    private ExcelWriter excelWriter;
    private Rectangle tournament;
    private Rectangle screen;
    private Rectangle okRec;
    private Rectangle eraseRec;
    private Rectangle coffeeRec;
    private Rectangle sandwichOneRec;
    private Rectangle coffeeAndRec;
    private Rectangle sandwichThreeRec;
    private Rectangle cakeTwoRec;
    private Rectangle cakeThreeRec;
    private Rectangle candyOneRec;
    private Rectangle cakeSixRec;
    private Rectangle energyRec;
    private Rectangle sodaRec;
    private Rectangle juiceRec;
    private Rectangle chocoRec;
    private Rectangle cakeFiveRec;
    private Rectangle cakeFourRec;

    private Texture screenBack;
    private Texture tournamentTexture;
    private Texture ok;
    private Texture erase;
    private Texture coffee;
    private Texture sandwichOne;
    private Texture coffeeAnd;
    private Texture sandwichThree;

    private Texture cakeTwo;
    private Texture cakeThree;
    private Texture candyOne;
    private Texture cakeSix;
    private Texture energy;
    private Texture soda;
    private Texture juice;
    private Texture choco;
    private Texture cakeFour;
    private Texture cakeFive;

    private Texture okDraw;
    private Texture eraseDraw;
    private Texture coffeeDraw;
    private Texture sandwichOneDraw;
    private Texture coffeeAndDraw;
    private Texture sandwichThreeDraw;
    private Texture cakeTwoDraw;
    private Texture cakeThreeDraw;
    private Texture candyOneDraw;
    private Texture cakeSixDraw;
    private Texture energyDraw;
    private Texture sodaDraw;
    private Texture juiceDraw;
    private Texture chocoDraw;
    private Texture cakeFourDraw;
    private Texture cakeFiveDraw;

    private Texture ok_1;
    private Texture erase_1;
    private Texture coffee_1;
    private Texture sandwichOne_1;
    private Texture coffeeAnd_1;
    private Texture sandwichThree_1;
    private Texture cakeTwo_1;
    private Texture cakeThree_1;
    private Texture candyOne_1;
    private Texture cakeSix_1;
    private Texture energy_1;
    private Texture soda_1;
    private Texture juice_1;
    private Texture choco_1;
    private Texture cakeFour_1;
    private Texture cakeFive_1;

    private List<Product> products;
    private float sum;
    private float totalTime;
    private float timeFromClick;
    private Timestamp timestamp;

    public Cafeteria(Kassa host) {
        this.host = host;
        batch = host.getBatch();
        touchPos = new Vector3();
        excelWriter = new ExcelWriter();

        tournamentTexture = new Texture("Turnaus_1.png");
        tournament = new Rectangle(host.WIDTH - 4* tournamentTexture.getWidth()/7f, host.HEIGHT - tournamentTexture.getHeight()/2f, tournamentTexture.getWidth()/2f, tournamentTexture.getHeight()/2f);
        screenBack = new Texture("back.png");
        screen = new Rectangle(0.9f*host.WIDTH -  screenBack.getWidth(), host.HEIGHT/100f, screenBack.getWidth(), host.HEIGHT - 16);
        products = new ArrayList<Product>();
        sum = 0;
        totalTime = 0;
        timeFromClick = 0;
        timestamp = new Timestamp((long) 0);

        createTextures();
        createSecondTextures();
        createRectangles();
        refreshTextures();

        Gdx.input.setInputProcessor(new GestureDetector(this));
    }

    private void createRectangles() {
        coffeeRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        coffeeAndRec = new Rectangle(coffeeRec.x + coffeeRec.width + 0.01f * host.WIDTH, host.HEIGHT - coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        sandwichOneRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 2 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        sandwichThreeRec= new Rectangle(coffeeRec.x + coffeeRec.width + 0.01f * host.WIDTH, host.HEIGHT - 2 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        cakeFiveRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 3 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        cakeTwoRec = new Rectangle(coffeeRec.x + coffeeRec.width + 0.01f * host.WIDTH, host.HEIGHT - 3 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        cakeThreeRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 4 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        cakeFourRec = new Rectangle(coffeeRec.x + coffeeRec.width + 0.01f * host.WIDTH, host.HEIGHT - 4 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        cakeSixRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 5 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        energyRec = new Rectangle(coffeeRec.x + coffeeRec.width + 0.01f * host.WIDTH, host.HEIGHT - 5 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        sodaRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 6 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        juiceRec = new Rectangle(coffeeRec.x + coffeeRec.width + 0.01f * host.WIDTH, host.HEIGHT - 6 * coffee.getHeight() / 1.3f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        candyOneRec = new Rectangle(0.01f * host.WIDTH, host.HEIGHT - 7 * coffee.getHeight() / 1.325f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        chocoRec = new Rectangle(coffeeRec.x + coffeeRec.width + 0.01f * host.WIDTH, host.HEIGHT - 7 * coffee.getHeight() / 1.325f, coffee.getWidth() / 1.3f, coffee.getHeight() / 1.3f);
        okRec = new Rectangle(screen.x + 3 * screen.width / 7f - ok.getWidth() / 1.7f, screen.y + 0.0125f * screen.height, ok.getWidth() / 1.7f, ok.getHeight() / 1.7f);
        eraseRec = new Rectangle(okRec.x - erase.getWidth() / 1.7f, okRec.y, erase.getWidth() / 1.7f, erase.getHeight() / 1.7f);
    }

    private void createTextures() {
        coffee = new Texture("kahvi_1.png");
        sandwichOne = new Texture("leipä1_1.png");
        coffeeAnd = new Texture("kahvi+_1.png");
        sandwichThree = new Texture("leipä3_1.png");
        //cakeOne = new Texture("leivos1_1.png");
        cakeTwo = new Texture("leivos2_1.png");
        cakeThree = new Texture("leivos3_1.png");
        candyOne = new Texture("Karkki1_1.png");
        cakeSix = new Texture("leivos6_2.png");
        energy = new Texture("Energia_1.png");
        soda = new Texture("limsa_1.png");
        juice = new Texture("mehu_1.png");
        choco = new Texture("suklaa_1.png");
        ok = new Texture("ok_1.png");
        erase = new Texture("poista_1.png");
        cakeFour = new Texture("leivos4_1.png");
        cakeFive = new Texture("leivos5_1.png");
    }

    private void createSecondTextures() {
        coffee_1 = new Texture("kahvi_2.png");
        sandwichOne_1 = new Texture("leipä1_2.png");
        coffeeAnd_1 = new Texture("kahvi+_2.png");
        sandwichThree_1 = new Texture("leipä3_2.png");
        //cakeOne_1 = new Texture("leivos1_2.png");
        cakeTwo_1 = new Texture("leivos2_2.png");
        cakeThree_1 = new Texture("leivos3_2.png");
        candyOne_1 = new Texture("Karkki1_2.png");
        cakeSix_1 = new Texture("leivos6_1.png");
        energy_1 = new Texture("Energia_2.png");
        soda_1 = new Texture("limsa_2.png");
        juice_1 = new Texture("mehu_2.png");
        choco_1 = new Texture("suklaa_2.png");
        ok_1 = new Texture("ok_2.png");
        erase_1 = new Texture("poista_2.png");
        cakeFour_1 = new Texture("leivos4_2.png");
        cakeFive_1 = new Texture("leivos5_2.png");
    }

    private void refreshTextures() {
        okDraw = ok;
        eraseDraw = erase;
        coffeeDraw = coffee;
        sandwichOneDraw = sandwichOne;
        coffeeAndDraw = coffeeAnd ;
        sandwichThreeDraw = sandwichThree ;
        cakeTwoDraw = cakeTwo;
        cakeThreeDraw = cakeThree;
        candyOneDraw = candyOne;
        cakeSixDraw = cakeSix;
        energyDraw = energy;
        sodaDraw = soda;
        juiceDraw = juice;
        chocoDraw = choco;
        cakeFourDraw = cakeFour;
        cakeFiveDraw = cakeFive;
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

        if(coffeeRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            coffeeDraw = coffee_1;
            Product product = new Coffee(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if(coffeeAndRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            coffeeAndDraw = coffeeAnd_1;
            Product product = new CoffeeAndCake(timestamp.toString());
            product.setPrice(2f);
            products.add(product);
            sum += product.getPrice();
        }
        if(sandwichOneRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            sandwichOneDraw = sandwichOne_1;
            Product product = new Sandwich(timestamp.toString(),"Kinkkusämpylä");
            product.setPrice(1f);
            products.add(product);
            sum += product.getPrice();
        }
        if(sandwichThreeRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            sandwichThreeDraw = sandwichThree_1;
            Product product = new Sandwich(timestamp.toString(),"Juustosämpylä");
            product.setPrice(1f);
            products.add(product);
            sum += product.getPrice();
        }
        if(cakeTwoRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            cakeTwoDraw = cakeTwo_1;
            Product product = new Cake(timestamp.toString(),"Veg. Marjapiiras");
            product.setPrice(1.5f);
            products.add(product);
            sum += product.getPrice();
        }
        if(cakeThreeRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            cakeThreeDraw = cakeThree_1;
            Product product = new Cake(timestamp.toString(),"Veg. Kasvispiiras");
            product.setPrice(1.5f);
            products.add(product);
            sum += product.getPrice();
        }
        if(candyOneRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            candyOneDraw = candyOne_1;
            Product product = new Candy(timestamp.toString(),"Laku");
            product.setPrice(0.5f);
            products.add(product);
            sum += product.getPrice();
        }
        if(cakeSixRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            cakeSixDraw = cakeSix_1;
            Product product = new Cake(timestamp.toString(),"Sitruunapiirakka");
            product.setPrice(1.5f);
            products.add(product);
            sum += product.getPrice();
        }
        if(energyRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            energyDraw = energy_1;
            Product product = new EnergyDrink(timestamp.toString());
            product.setPrice(1.5f);
            products.add(product);
            sum += product.getPrice();
        }
        if(sodaRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            sodaDraw = soda_1;
            Product product = new Soda(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if(juiceRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            juiceDraw = juice_1;
            Product product = new Juice(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if(chocoRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            chocoDraw = choco_1;
            Product product = new Chocolate(timestamp.toString());
            products.add(product);
            sum += product.getPrice();
        }
        if(cakeFourRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            cakeFourDraw = cakeFour_1;
            Product product = new Cake(timestamp.toString(),"Kinkkupiiras");
            product.setPrice(1.5f);
            products.add(product);
            sum += product.getPrice();
        }
        if(cakeFiveRec.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            cakeFiveDraw = cakeFive_1;
            Product product = new Cake(timestamp.toString(), "Tonnikalapiiras");
            product.setPrice(1.5f);
            products.add(product);
            sum += product.getPrice();
        }
        if(tournament.contains(touchPos.x, touchPos.y)){
            touchPos.x = 0;
            touchPos.y = 0;
            host.setScreen(new Tournament(host));
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
        batch.draw(coffeeDraw, coffeeRec.x, coffeeRec.y, coffeeRec.width, coffeeRec.height);
        batch.draw(sandwichOneDraw, sandwichOneRec.x, sandwichOneRec.y, sandwichOneRec.width, sandwichOneRec.height);
        batch.draw(coffeeAndDraw, coffeeAndRec.x, coffeeAndRec.y, coffeeAndRec.width, coffeeAndRec.height);
        batch.draw(sandwichThreeDraw, sandwichThreeRec.x, sandwichThreeRec.y, sandwichThreeRec.width, sandwichThreeRec.height);
        batch.draw(cakeTwoDraw, cakeTwoRec.x, cakeTwoRec.y, cakeTwoRec.width, cakeTwoRec.height);
        batch.draw(cakeThreeDraw, cakeThreeRec.x, cakeThreeRec.y, cakeThreeRec.width, cakeThreeRec.height);
        batch.draw(candyOneDraw, candyOneRec.x, candyOneRec.y, candyOneRec.width, candyOneRec.height);
        batch.draw(cakeSixDraw, cakeSixRec.x, cakeSixRec.y, cakeSixRec.width, cakeSixRec.height);
        batch.draw(energyDraw, energyRec.x, energyRec.y, energyRec.width, energyRec.height);
        batch.draw(sodaDraw, sodaRec.x, sodaRec.y, sodaRec.width, sodaRec.height);
        batch.draw(chocoDraw, chocoRec.x, chocoRec.y, chocoRec.width, chocoRec.height);
        batch.draw(juiceDraw, juiceRec.x, juiceRec.y, juiceRec.width, juiceRec.height);
        batch.draw(cakeFourDraw, cakeFourRec.x, cakeFourRec.y, cakeFourRec.width, cakeFourRec.height);
        batch.draw(cakeFiveDraw, cakeFiveRec.x, cakeFiveRec.y, cakeFiveRec.width, cakeFiveRec.height);
        batch.draw(tournamentTexture,tournament.x,tournament.y,tournament.width,tournament.height);
        batch.draw(screenBack, screen.x, screen.y, screen.width, screen.height);
        drawProducts();
        host.roboto.draw(batch, "Yhteensä: " + sum + "€", screen.x + 3 * screen.width / 7f, screen.y + screen.height / 15f);
        batch.draw(okDraw, okRec.x, okRec.y, okRec.width, okRec.height);
        batch.draw(eraseDraw, eraseRec.x, eraseRec.y, eraseRec.width, eraseRec.height);
        batch.end();

        if (totalTime - timeFromClick > 0.25f) {
            refreshTextures();
        }

    }

    private void drawProducts() {
        for (int i = 0; i < products.size(); i++) {
            host.roboto.draw(batch, products.get(i).getName(), screen.x + screen.width / 20f, screen.y + screen.getHeight() - (i + 1) * screen.getHeight() / 15);
            host.roboto.draw(batch, products.get(i).toString(), screen.x + 15*screen.width / 20f, screen.y + screen.getHeight() - (i + 1) * screen.getHeight() / 15);
        }
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
    public void resize(int width, int height) {

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
        tournamentTexture.dispose();
        screenBack.dispose();
        ok.dispose();
        okDraw.dispose();
        ok_1.dispose();
        erase.dispose();
        erase_1.dispose();
        eraseDraw.dispose();
        screenBack.dispose();
        tournamentTexture.dispose();
        ok.dispose();
        erase.dispose();
        coffee.dispose();
        sandwichOne.dispose();
        coffeeAnd.dispose();
        sandwichThree.dispose();
        cakeTwo.dispose();
        cakeThree.dispose();
        candyOne.dispose();
        cakeSix.dispose();
        energy.dispose();
        soda.dispose();
        juice.dispose();
        choco.dispose();

        okDraw.dispose();
        eraseDraw.dispose();
        coffeeDraw.dispose();
        sandwichOneDraw.dispose();
        coffeeAndDraw.dispose();
        sandwichThreeDraw.dispose();
        cakeTwoDraw.dispose();
        cakeThreeDraw.dispose();
        candyOneDraw.dispose();
        cakeSixDraw.dispose();
        energyDraw.dispose();
        sodaDraw.dispose();
        juiceDraw.dispose();
        chocoDraw.dispose();

        ok_1.dispose();
        erase_1.dispose();
        coffee_1.dispose();
        sandwichOne_1.dispose();
        coffeeAnd_1.dispose();
        sandwichThree_1.dispose();
        cakeTwo_1.dispose();
        cakeThree_1.dispose();
        candyOne_1.dispose();
        cakeSix_1.dispose();
        energy_1.dispose();
        soda_1.dispose();
        juice_1.dispose();
        choco_1.dispose();
    }
}
