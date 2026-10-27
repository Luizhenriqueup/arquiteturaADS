package br.com.hexagonal.infra.adapters.out.email;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

import org.springframework.stereotype.Component;

import br.com.hexagonal.domain.entities.Fatura;
import br.com.hexagonal.domain.ports.out.email.NotificacaoEmail;

@Component
public class NotificacaoEmailImp implements NotificacaoEmail {

  @Override
  public String notificar(Fatura fatura) {
    String conteudo = "Fatura " + fatura.getId()
      + " do pedido " + fatura.getPedidoId()
      + " no valor de " + fatura.getValor()
      + ". Boleto: " + fatura.getCodigoBarras()
      + ". Nota fiscal: " + fatura.getChaveAcesso();
    System.out.println("[SMTP] e-mail enviado: " + conteudo);
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(conteudo.getBytes(StandardCharsets.UTF_8));
      return HexFormat.of().formatHex(hash);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Não foi possível gerar o hash do e-mail!");
    }
  }

}
