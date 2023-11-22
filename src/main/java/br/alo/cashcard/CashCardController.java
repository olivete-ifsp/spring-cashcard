package br.alo.cashcard;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    private final CashCardRepository cashCardRepository;

    private CashCardController(CashCardRepository cashCardRepository) {
       this.cashCardRepository = cashCardRepository;
    }

    // @GetMapping("/{requestedId}")
    // private ResponseEntity<String> findById() {
    // return ResponseEntity.ok("{}");
    // }

    // @GetMapping("/{requestedId}")
    // private ResponseEntity<CashCard> findById(@PathVariable Long requestesdId) {
    //     CashCard cashCard = new CashCard(99L, 123.45);
    //     return ResponseEntity.ok(cashCard);
    // }

    @GetMapping("/{requestedId}")
    private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);
        if (cashCardOptional.isPresent()) {
            return ResponseEntity.ok(cashCardOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
