package net.daisyquest.daisyquestgame.Controller;


import net.daisyquest.daisyquestgame.Model.Quest;
import net.daisyquest.daisyquestgame.Model.QuestCompletionResult;
import net.daisyquest.daisyquestgame.Service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quests")
public class QuestController {

    @Autowired
    private QuestService questService;

    @PostMapping
    public ResponseEntity<Quest> createQuest(@RequestBody Quest quest) {
        return ResponseEntity.ok(questService.createQuest(quest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quest> getQuest(@PathVariable String id) {
        Quest quest = questService.getQuest(id);
        return quest != null ? ResponseEntity.ok(quest) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Quest>> getAllQuests() {
        return ResponseEntity.ok(questService.getAllQuests());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quest> updateQuest(@PathVariable String id, @RequestBody Quest quest) {
        quest.setId(id);
        return ResponseEntity.ok(questService.updateQuest(quest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuest(@PathVariable String id) {
        questService.deleteQuest(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{questId}/start")
    public ResponseEntity<Quest> startQuest(@PathVariable String questId, @RequestParam String playerId) {
        Quest startedQuest = questService.startQuest(questId, playerId);
        if (startedQuest != null) {
            return ResponseEntity.ok(startedQuest);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{questId}/complete")
    public ResponseEntity<QuestCompletionResult> completeQuest(@PathVariable String questId, @RequestParam String playerId) {
        QuestCompletionResult result = questService.completeQuest(questId, playerId);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

