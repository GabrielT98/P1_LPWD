package br.edu.universidadedevassouras.prova.controller;

import br.edu.universidadedevassouras.prova.model.Endereco;
import br.edu.universidadedevassouras.prova.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {
        @Autowired
        private EnderecoRepository _enderecoRepository;

        @RequestMapping(value = "/endereco", method = RequestMethod.GET)
        public List<Endereco> Get() {
            return _enderecoRepository.findAll();
        }

        @RequestMapping(value = "/endereco/{id}", method = RequestMethod.GET)
        public ResponseEntity<Endereco> GetById(@PathVariable(value = "id") long id) {
            Optional<Endereco> endereco = _enderecoRepository.findById(id);
            if (endereco.isPresent())
                return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @RequestMapping(value = "/endereco", method = RequestMethod.POST)
        public Endereco Post(@Valid @RequestBody Endereco endereco) {
            return _enderecoRepository.save(endereco);
        }

        @RequestMapping(value = "/endereco/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Endereco> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Endereco newEndereco) {
            Optional<Endereco> oldEndereco = _enderecoRepository.findById(id);
            if (oldEndereco.isPresent()) {
                Endereco endereco = oldEndereco.get();
                endereco.setCep(newEndereco.getCep());
                endereco.setTipoLogradouro(newEndereco.getTipoLogradouro());
                endereco.setLogradouro(newEndereco.getLogradouro());
                endereco.setNumero(newEndereco.getNumero());
                endereco.setBairro(newEndereco.getBairro());
                endereco.setCidade(newEndereco.getCidade());
                endereco.setEstado(newEndereco.getEstado());
                endereco.setPais(newEndereco.getPais());
                _enderecoRepository.save(endereco);
                return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @RequestMapping(value = "/endereco/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
            Optional<Endereco> endereco = _enderecoRepository.findById(id);
            if (endereco.isPresent()) {
                _enderecoRepository.delete(endereco.get());
                return new ResponseEntity<>(HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


