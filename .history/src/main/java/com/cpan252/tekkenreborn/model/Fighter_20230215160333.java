package com.cpan252.tekkenreborn.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.google.common.collect.Tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
// By using the @Table annotation, we are telling Spring Data to map the table
// name to the table
Tables
public class Fighter {
    public enum Anime {
        Jujutsu_Kaisen("Jujutsu Kaisen"), POKEMON("POKEMON"), INUAHSA("INUAHSA"), TEKKEN("Tekken");

        private String title;

        private Anime(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public static Object builder() {
        return null;
    }

    public String getName() {
        return null;
    }

    public int getDamagePerHit() {
        return 0;
    }

    public int getHealth() {
        return 0;
    }

    public BigDecimal getResistance() {
        return null;
    }

    public Object getAnimeFrom() {
        return null;
    }

    public Object getCreatedAt() {
        return null;
    }
}
