package net.daisyquest.daisyquestgame.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "troops")
public class Troop {
    @Id
    private String id;
    @DBRef
    private TroopType troopType;
    private int hp;
    private int level;
    private int attackPower;
    private int defensePower;
    private double hpMod;
    private double apMod;
    private double dpMod;
    private boolean isHostile;
    private boolean isNeutral = false;
    private int killCount = 0;
    private String title;

    private int experience = 0;

    private Position position = Position.FRONTLINE;

    public enum Position {
        FRONTLINE, BACKLINE, ATTACKING
    }

}
