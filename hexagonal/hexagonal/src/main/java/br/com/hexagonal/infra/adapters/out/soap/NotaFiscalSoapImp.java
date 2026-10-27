package br.com.hexagonal.infra.adapters.out.soap;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import br.com.hexagonal.domain.entities.Fatura;
import br.com.hexagonal.domain.ports.out.soap.NotaFiscalSoap;

@Component
public class NotaFiscalSoapImp implements NotaFiscalSoap {

  @Override
  public String emitirNota(Fatura fatura) {
    System.out.println("[SOAP] nota fiscal solicitada para a fatura " + fatura.getId());
    StringBuilder chaveAcesso = new StringBuilder();
    for (int i = 0; i < 44; i++) {
      chaveAcesso.append(ThreadLocalRandom.current().nextInt(10));
    }
    return chaveAcesso.toString();
  }

}
