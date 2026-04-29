package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os meus Ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());


    }

    // Listar todos os meus Ninjas por ID
    // Usando o OPTIONAL --> Pois o ID do ninja pode ou nao exister na tabela de banco de dados
    public NinjaModel listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar um novo Ninja
    public NinjaDTO criarNinjas(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar o Ninja  --> Tem que ser um metodo Void
    public void deletarNinjasPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Atualizar Ninja
    public NinjaModel atualizarNinja(Long id, NinjaDTO ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaMapper.map(ninjaAtualizado));
        }
        else  {
            return null;
        }
    }

}










