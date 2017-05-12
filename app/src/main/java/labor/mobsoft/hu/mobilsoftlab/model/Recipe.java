package labor.mobsoft.hu.mobilsoftlab.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

/**
 * Created by Koszta Ádám on 2017. 04. 18..
 */

@Table
public class Recipe {
    @SerializedName("id")
    @Unique
    private Long id;

    private String title;
    private String imgUrl;
    private String totalTime;
    private int difficulty;
    private String ingredients;
    private String description;

    public Recipe() {
    }

    public Recipe(Long id, String title, String imgUrl, String totalTime, int difficulty, String ingredients, String description) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.totalTime = totalTime;
        this.difficulty = difficulty;
        this.ingredients = ingredients;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
