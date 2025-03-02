# Sorteador de Amigo Secreto

Este projeto é um **sorteador de amigo secreto** desenvolvido como parte do **ONE - Oracle Next Education (ONE)**. O objetivo deste projeto é permitir que você sorteie aleatoriamente os amigos secretos entre um grupo de pessoas.

Atualmente, o sorteio funciona localmente, e os nomes dos amigos devem ser inseridos manualmente. O projeto utiliza **JavaScript**, **HTML** e **CSS** para fornecer a interface e a funcionalidade.

## Funcionalidades

- **Adicionar Amigos**: Insira o nome dos amigos na lista para que eles possam ser sorteados.
- **Sorteio Aleatório**: Ao clicar no botão de sorteio, o sistema escolhe um amigo aleatoriamente.
- **Resultado do Sorteio**: O nome do amigo sorteado é exibido na tela.

## Como Usar

1. Abra o arquivo `index.html` em um navegador.
2. No campo de input, insira o nome de um amigo e clique no botão "Adicionar".
3. Quando todos os amigos forem adicionados, clique no botão "Sortear" para ver o amigo secreto sorteado.

## Como Funciona

1. O sistema utiliza uma lista de amigos (`let amigos = []`) que é preenchida à medida que você adiciona nomes.
2. Após adicionar pelo menos um nome, você pode clicar no botão "Sortear", que selecionará um nome aleatório da lista e exibirá o nome do amigo secreto sorteado.
3. O sistema limpa a lista de amigos após o sorteio para garantir que não sejam sorteados novamente.

## Tecnologias Utilizadas

- **HTML5**: Estrutura da página.
- **CSS3**: Estilização da página.
- **JavaScript**: Lógica de sorteio e interação com o usuário.
