package com.fedex.modal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    Map<String, String> tracks;

    @JsonAnyGetter
    public Map<String, String> getTracks() {
        return this.tracks;
    }

    @JsonAnySetter
    public void addTrack(String id, String status) {
        if (tracks == null) {
            tracks = new HashMap<>();
        }

        tracks.put(id, status);
    }
}
