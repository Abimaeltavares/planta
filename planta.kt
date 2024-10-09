fun main() {
    val products = mutableListOf<Product>()
    val productions = mutableMapOf<Product, MutableList<Production>>()

    println("Bem-vindo ao PlanTEI!")
    println("Selecione uma opção:")
    println("1. Cadastrar produto")
    println("2. Acompanhar produção")
    println("3. Controlar estoque")
    println("4. Gerar relatórios")
    println("5. Sair")

    while (true) {
        print("Opção: ")
        val option = readLine()!!.trim()

        when (option) {
            "1" -> {
                println("Cadastro de produto")
                println("Nome do produto: ")
                val name = readLine()!!.trim()
                println("Tipo do produto (fruta, verdura, legume): ")
                val type = readLine()!!.trim()
                println("Cultura do produto (hortaliça, frutífera, folhagem, aromáticas, medicinais, outros): ")
                val culture = readLine()!!.trim()
                println("Data de plantio (dd/mm/yyyy): ")
                val plantingDate = readLine()!!.trim()
                println("Previsão de colheita (dd/mm/yyyy): ")
                val harvestDate = readLine()!!.trim()

                val product = Product(name, type, culture, plantingDate, harvestDate)
                products.add(product)
                productions[product] = mutableListOf()
                println("Produto cadastrado com sucesso!")
            }
            "2" -> {
                println("Acompanhamento de produção")
                println("Selecione um produto:")
                products.forEachIndexed { index, product ->
                    println("${index + 1}. ${product.name}")
                }
                val productIndex = readLine()!!.trim().toInt() - 1
                val product = products[productIndex]
                println("Quantidade produzida (kg): ")
                val quantity = readLine()!!.trim().toDouble()

                val production = Production(quantity)
                productions[product]!!.add(production)
                println("Produção registrada com sucesso!")
            }
            "3" -> println("Controle de estoque selecionado")
            "4" -> println("Geração de relatórios selecionado")
            "5" -> {
                println("Saindo do sistema...")
                return
            }
            else -> println("Opção inválida. Tente novamente.")
        }

        println("Produtos cadastrados:")
        products.forEach { println(it) }

        println("Produção por produto:")
        productions.forEach { (product, productions) ->
            println("Produto: ${product.name}")
            productions.forEachIndexed { index, production ->
                println("  ${index + 1}. Quantidade: ${production.quantity} kg")
            }
        }
    }
}

data class Product(val name: String, val type: String, val culture: String, val plantingDate: String, val harvestDate: String) {
    override fun toString(): String {
        return "Produto: $name, Tipo: $type, Cultura: $culture, Data de plantio: $plantingDate, Previsão de colheita: $harvestDate"
    }
}

data class Production(val quantity: Double)