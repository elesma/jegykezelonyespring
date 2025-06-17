package huelesm.jegykezelo2.controller;

import huelesm.jegykezelo2.model.Rendezveny;
import huelesm.jegykezelo2.repository.RendezvenyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class RendezvenyController {

    private final RendezvenyRepository repository;

    public RendezvenyController(RendezvenyRepository repository) {
        this.repository = repository;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/kezdolap")
    public String kezdolap() {
        return "kezdolap.html";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/elozmenyek")
    public String elozmenyek() {
        return "elozmenyek.html";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/reg")
    public String reg() {
        return "reg.html";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/rendezvenyIndex")
    public String rendezvenyIndex() {
        return "rendezveny.html";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/rendezvenyIndex2")
    public String rendezvenyIndex2() {
        return "rendezveny2.html";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/uj")
    public String hozzaadas(@ModelAttribute Rendezveny rendezveny) {
        repository.save(rendezveny);
        return "redirect:http://127.0.0.1:8080/kezdolap";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/ertekeles/{id}")
    public String frissitErtekeles(@PathVariable Long id, @RequestParam int ujErtekeles) {
        Rendezveny r = repository.findById(id).orElse(null);
        if (r != null) {
            r.setErtekeles(ujErtekeles);
            repository.save(r);
        }
        return "";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/torol/{id}")
    public String torolEsemeny(@PathVariable Long id) {
        Rendezveny r = repository.findById(id).orElse(null);
        if (r != null) {
            repository.deleteById(id);
            repository.save(r);
        }
        return "";
    }

    @CrossOrigin(origins = "*")
    @ResponseBody
    @GetMapping("/api/lista")
    public ResponseEntity<List<Rendezveny>> rendezvenyApiLista() {
        return ResponseEntity.ok(repository.findAll());
    }
    @CrossOrigin(origins = "*")
    @ResponseBody
    @GetMapping("/api/getrendezvenybyid/{id}")
    public ResponseEntity<Rendezveny> getRendezvenyById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}