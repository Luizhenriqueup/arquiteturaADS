package br.com.hexagonal.infra.adapters.out.messaging;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import br.com.hexagonal.domain.entities.Fatura;
import br.com.hexagonal.domain.ports.out.messaging.BoletoMessaging;

@Component
public class BoletoMessagingImp implements BoletoMessaging {

  @Override
  public String emitirBoleto(Fatura fatura) {
    System.out.println("[FILA] boleto solicitado para a fatura " + fatura.getId());
    StringBuilder codigoBarras = new StringBuilder();
    for (int i = 0; i < 47; i++) {
      codigoBarras.append(ThreadLocalRandom.current().nextInt(10));
    }
    return codigoBarras.toString();
  }

}
