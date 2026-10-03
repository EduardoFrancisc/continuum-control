package br.edu.infnet.continuum.exception;

import br.edu.infnet.continuum.domain.enums.EspecialidadeAgente;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import tools.jackson.databind.exc.InvalidFormatException;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Para os gets, consultas pelos enuns de especialidade e situação
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidation(MethodArgumentTypeMismatchException ex){
        if (ex.getRequiredType() == SituacaoAgente.class){
            return Map.of("timestamp", LocalDateTime.now(),
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "error", "Bad Request",
                    "message", "Tipos de situações aceitas: DISPONÍVEL, EM_MISSÃO, SUSPENSO, INATIVO"
            );
        }

        if (ex.getRequiredType() == EspecialidadeAgente.class){
            return Map.of("timestamp", LocalDateTime.now(),
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "error", "Bad Request",
                    "message", "Tipos de especialidade aceitas: INVESTIGACAO, CONTENCAO_FISICA, ANALISE_HISTORICA, ENGENHARIA_TEMPORAL"
            );
        }

        return Map.of("timestamp", LocalDateTime.now(),
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Bad Request",
                "message", ex.getMessage()
        );
    }

    //Para o post, criação do agente
    @ExceptionHandler(HttpMessageNotReadableException.class) //exception genérica
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Map<String, Object> handleCreationsValidation(HttpMessageNotReadableException ex){
        if (ex.getCause() instanceof InvalidFormatException i){ //varifica se é a forma do json (request body) que veio errada ou não bate com o enum
            if (i.getTargetType() == SituacaoAgente.class){
                return Map.of("timestamp", LocalDateTime.now(),
                        "status", HttpStatus.NOT_ACCEPTABLE.value(),
                        "error", "Not Acceptable",
                        "message", "Tipos de situações aceitas: DISPONÍVEL, EM_MISSÃO, SUSPENSO, INATIVO"
                );
            }

            if (i.getTargetType() == EspecialidadeAgente.class){
                return Map.of("timestamp", LocalDateTime.now(),
                        "status", HttpStatus.NOT_ACCEPTABLE.value(),
                        "error", "Not Acceptable",
                        "message", "Tipos de especialidade aceitas: INVESTIGACAO, CONTENCAO_FISICA, ANALISE_HISTORICA, ENGENHARIA_TEMPORAL"
                );
            }
        }

        return Map.of("timestamp", LocalDateTime.now(),
                "status", HttpStatus.NOT_ACCEPTABLE.value(),
                "error", "Not Acceptable",
                "message", ex.getMessage()
        );

    }

    @ExceptionHandler(EntidadeNaoLocalizada.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleEntidadeValidation(EntidadeNaoLocalizada ex){
        return Map.of("timestamp", LocalDateTime.now(),
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Not Acceptable",
                "message", ex.getMessage()
        );
    }

    @ExceptionHandler(AgenteDeletado.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleAgenteDeletadoValidation(AgenteDeletado ex){
        return Map.of("timestamp", LocalDateTime.now(),
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Not Acceptable",
                "message", ex.getMessage()
        );
    }







}
