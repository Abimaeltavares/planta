fun main() {
    var option: Int

    do {
        println("Menu da Aplicação PlanTEI")
        println("1. Cadastrar Produto")
        println("2. Acompanhar Produção")
        println("3. Controle de Estoque")
        println("4. Gerar Relatórios")
        println("0. Sair")
        println("Escolha uma opção:")
        option = readLine()?.toIntOrNull() ?: -1

        when (option) {
            1 -> println("Cadastrar Produto")
            2 -> println("Acompanhar Produção")
            3 -> println("Controle de Estoque")
            4 -> println("Gerar Relatórios")
            0 -> println("Saindo...")
            else -> println("Opção inválida, tente novamente.")
        }
    } while (option != 0)
}
