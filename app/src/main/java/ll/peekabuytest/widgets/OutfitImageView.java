package ll.peekabuytest.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ll.peekabuytest.Constants;
import ll.peekabuytest.models.Product;
import ll.peekabuytest.models.events.FragmentChangeEvent;
import ll.peekabuytest.models.events.SelectedItemSizeChangedEvent;
import ll.peekabuytest.networks.APIEndpoint;

/**
 * Created by Le on 2016/3/7.
 */

/**
 * "products": [5]
 * 0:  {
 * "merchant": ""
 * "sub_category": "Blouses"
 * "price": "$79.99"
 * "brand_name": "MANGO"
 * "product_url": "http://www.polyvore.com/shop/thing?id=161316427"
 * "currency": "$"
 * "colors": [0]
 * "num_likes": 1
 * "y_1": 0.6104294478527608
 * "x_0": 0.06896551724137931
 * "x_1": 0.4827586206896552
 * "price_cents": 7999
 * "date_saved": "2016-02-26 15:50:59"
 * "id": "p-2040299"
 * "color_swatch_url": [0]
 * "description": "MANGO MANGO Beaded Chiffon Blouse"
 * "color_images_url": [0]
 * "alt_images_url": [1]
 * 0:  "https://peekabuy.s3.amazonaws.com/products/image/7b14da7cc44891f8d552e36540e3278a.jpg"
 * -
 * "update_time_sec": 1456530659
 * "main_category": "Tops"
 * "fair_market_price_cents": 7999
 * "type": "closet"
 * "sizes": [0]
 * "image_width": 1001
 * "fair_market_price": "$79.99"
 * "y_0": 0.06134969325153374
 * "user_info": {
 * "board_name": "My Closet"
 * "user_liked": false
 * "board_id": 66395
 * "user_saved_wishlist": false
 * "user_saved_closet": true
 * }-
 * "image_height": 1400
 * "image_url": "https://peekabuy.s3.amazonaws.com/products/image/7b14da7cc44891f8d552e36540e3278a.jpg"
 * "details": ""
 * "in_stock": false
 * "num_saves": 1
 * }-
 * 1:  {
 * "merchant": "Macy's"
 * "sub_category": "Bralets"
 * "price": "$29.00"
 * "brand_name": "INC International Concepts"
 * "product_url": "https://www.mychameleon.com.au/silk-float-bra-p-1742.html"
 * "currency": "$"
 * "colors": [0]
 * "masked_image_url": "https://peekabuy.s3.amazonaws.com/uploads/mixmatch/crop_rgba/a5cc97143eaf5a0740e428869d34699e.png"
 * "num_likes": 0
 * "y_1": 0.37423312883435583
 * "x_0": 0.5172413793103449
 * "x_1": 0.9310344827586207
 * "price_cents": 2900
 * "id": "p-2342"
 * "color_swatch_url": [0]
 * "description": "INC International Concepts T Shirt, V Neck Chaos"
 * "color_images_url": [0]
 * "alt_images_url": [1]
 * 0:  "https://peekabuy.s3.amazonaws.com/polyvore/items/83508137.jpeg"
 * -
 * "update_time_sec": 1455950034
 * "main_category": "Tops"
 * "fair_market_price_cents": 2900
 * "type": null
 * "sizes": [0]
 * "image_width": 400
 * "fair_market_price": "$29.00"
 * "y_0": 0.0736196319018405
 * "user_info": {
 * "user_liked": false
 * "user_saved_wishlist": false
 * "user_saved_closet": false
 * }-
 * "image_height": 329
 * "image_url": "https://peekabuy.s3.amazonaws.com/polyvore/items/83508137.jpeg"
 * "in_stock": false
 * "num_saves": 0
 * }-
 * 2:  {
 * "merchant": "mimiboutique.com"
 * "sub_category": "Clutches"
 * "price": "$44.00"
 * "brand_name": ""
 * "product_url": "http://www.mimiboutique.com/handbags/brando-clutch-in-black.html"
 * "currency": "$"
 * "in_stock": false
 * "masked_image_url": "https://peekabuy.s3.amazonaws.com/uploads/mixmatch/crop_rgba/5783c23cdcd17bd693fda8e0778e0b4b.png"
 * "num_likes": 0
 * "y_1": 0.5920245398773006
 * "x_0": 0.5172413793103449
 * "x_1": 0.9310344827586207
 * "price_cents": 4400
 * "id": "p-262037"
 * "color_swatch_url": [0]
 * "description": "Clutch with Zipper Detail in Black"
 * "color_images_url": [0]
 * "alt_images_url": [1]
 * 0:  "https://peekabuy.s3.amazonaws.com/polyvore/items/52211185.jpeg"
 * -
 * "update_time_sec": 1442154797
 * "main_category": "Bags"
 * "fair_market_price_cents": 4400
 * "image_width": 400
 * "fair_market_price": "$44.00"
 * "y_0": 0.4049079754601227
 * "user_info": {
 * "user_liked": false
 * "user_saved_wishlist": false
 * "user_saved_closet": false
 * }-
 * "image_height": 206
 * "image_url": "https://peekabuy.s3.amazonaws.com/styleit/foregroundcrop/9e6e4a79e0557cf12fd10bd564ecdfdc.jpeg"
 * "type": null
 * "num_saves": 0
 * }-
 * 3:  {
 * "merchant": "romwe.com"
 * "sub_category": "Shorts"
 * "price": "$28.00"
 * "brand_name": ""
 * "product_url": "http://www.romwe.com/black-vinyl-shorts-p-50775.html"
 * "currency": "$"
 * "in_stock": false
 * "masked_image_url": "https://peekabuy.s3.amazonaws.com/uploads/mixmatch/crop_rgba/794640efac79a003d616684d3e46035f.png"
 * "num_likes": 0
 * "y_1": 0.9263803680981595
 * "x_0": 0.5172413793103449
 * "x_1": 0.9310344827586207
 * "price_cents": 2800
 * "id": "p-35433"
 * "color_swatch_url": [0]
 * "description": "Black Vinyl Shorts"
 * "color_images_url": [0]
 * "alt_images_url": [1]
 * 0:  "https://peekabuy.s3.amazonaws.com/polyvore/items/72433698.jpeg"
 * -
 * "update_time_sec": 1441917740
 * "main_category": "Bottoms"
 * "fair_market_price_cents": 2800
 * "image_width": 300
 * "fair_market_price": "$28.00"
 * "y_0": 0.6226993865030674
 * "user_info": {
 * "user_liked": false
 * "user_saved_wishlist": false
 * "user_saved_closet": false
 * }-
 * "image_height": 300
 * "image_url": "https://peekabuy.s3.amazonaws.com/styleit/foregroundcrop/e50289d75f56f5429cada7160a7e93a4.jpeg"
 * "type": null
 * "num_saves": 0
 * }-
 * 4:  {
 * "merchant": ""
 * "owner_name": "Xi Liu"
 * "sub_category": "Pumps"
 * "brand": ""
 * "brand_name": ""
 * "product_url": ""
 * "web_url": ""
 * "x_0": 0.06896551724137931
 * "x_1": 0.4827586206896552
 * "date_saved": "2015-03-30 16:34:33"
 * "id": "i-349149"
 * "description": ""
 * "main_category": "Shoes"
 * "image_width": 1093
 * "y_1": 0.9386503067484663
 * "y_0": 0.6411042944785276
 * "user_info": {
 * "board_name": "My Closet"
 * "user_saved_closet": true
 * "board_id": 66395
 * "user_saved_wishlist": false
 * }-
 * "image_height": 1063
 * "image_url": "https://peekabuy.s3.amazonaws.com/uploads/mixmatch/useritem/1c2eb1c805457fd81336917a637a4d6e.jpeg"
 * "owner_image_url": "http://styleitapp.com/profile_image/6134g78r4/"
 * "type": "closet"
 * "price": ""
 * "owner_username": "xi-liu1"
 * }
 */
public class OutfitImageView extends ImageView implements View.OnTouchListener {
    //float[] xy = {0.06896551724137931f,0.3338368580060423f, 0.4827586206896552f, 0.6661631419939577f};
    private float[] coordinates = new float[4];
    private boolean isTapped = false;
    private Product selectedPruduct;
    private Bitmap mItemBitmap = null;

    public void setTapped(boolean tapped) {
        isTapped = tapped;
    }

    public boolean isTapped() {
        return isTapped;
    }

    private List<Product> mProducts = Collections.emptyList();

    public OutfitImageView(Context context) {
        super(context);
    }

    public OutfitImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OutfitImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public List<Product> getProducts() {
        return mProducts;
    }

    public OutfitImageView setProducts(List<Product> products) {
        mProducts = products;
        printProducts();
        return this;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isTapped) {
            float[] xy = getRect();
            Paint paint = new Paint();
            paint.setColor(Color.MAGENTA);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            canvas.drawRect(xy[0], xy[1], xy[2], xy[3], paint);

            if (selectedPruduct != null && mItemBitmap != null) {
                canvas.drawBitmap(scale(mItemBitmap, xy[2] - xy[0], xy[3] - xy[1]), xy[0], xy[1], null);
            }
        } else {
            canvas.restore();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int width = this.getWidth();
        int height = this.getHeight();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (Product item : mProducts) {
                float[] xyz = item.getCoordinates();
                if (event.getX() > width * xyz[0] && event.getX() < width * xyz[2] && event.getY() > height * xyz[1] && event.getY() < height * xyz[3]) {
                    if (item.equals(selectedPruduct)) {
                        isTapped = false;
                        selectedPruduct = null;
                        EventBus.getDefault().postSticky(new FragmentChangeEvent(false));
                        Log.v("OutfitImageView", "isTapped :" + isTapped);
                        invalidate();
                    } else {
                        selectedPruduct = item;
                        if (mItemBitmap != null) {
                            mItemBitmap.recycle();
                            mItemBitmap = null;
                        }
                        EventBus.getDefault().postSticky(new FragmentChangeEvent(true));
                        APIEndpoint.requestSimilarProducts(Constants.TEST_USERNAME, this.selectedPruduct.id, this.selectedPruduct);
                        isTapped = true;
                        if (!Arrays.equals(xyz, coordinates)) {
                            coordinates = xyz;
                            float[] newRect = getRect();
                            EventBus.getDefault().post(new SelectedItemSizeChangedEvent(newRect[2] - newRect[0], newRect[3] - newRect[1]));
                        }
                        Log.v("OutfitImageView", "Selected Item :" + selectedPruduct.toString());
                    }
                    invalidate();
                    break;
                } else {
                    if (isTapped) {
                        isTapped = false;
                        EventBus.getDefault().postSticky(new FragmentChangeEvent(false));
                        invalidate();
                    }
                }
            }
            Log.v("window", "tapped," + event.getX() + " " + event.getY() + "item selected: " + isTapped);
        }
        return true;
    }

    private void printProducts() {
        if (!mProducts.isEmpty()) {
            for (Product item : mProducts) {
                Log.v("Products", item.toString());
            }
        }
    }

    private Bitmap scale(Bitmap src, float newWidth, float newHeight) {
        float width = src.getWidth();
        float height = src.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = newWidth / width;
        float scaleHeight = newHeight / height;
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(src, 0, 0, (int) width, (int) height,
                matrix, true);
    }

    public float[] getRect() {
        int width = this.getWidth();
        int height = this.getHeight();
        float leftx = width * coordinates[0];
        float topy = height * coordinates[1];
        float rightx = width * coordinates[2];
        float bottomy = height * coordinates[3];
        return new float[]{leftx, topy, rightx, bottomy};
    }

    public void setItemBitmap(Bitmap itemBitmap) {
        this.mItemBitmap = itemBitmap;
        invalidate();
    }
}
