Feature: Contas
	As um usuario
	I quero cadastrar contas
	In poder distribuir meu dinheiro de forma organizada


Scenario: Deve inserir uma conta com sucesso
	Given que estou acessando a aplicacao
	When informo o usuario "user@123"
	And a senha "user"
	And seleciono entrar
	Then visualizo a pagina inicial
	When seleciono contas
	And seleciono Adicionar
	And informo a conta "Conta de teste"
	And seleciono salvar
	Then a conta e inserida com sucesso
	
Scenario: Nao deve inserir uma conta sem nome
	Given que estou acessando a aplicacao
	When informo o usuario "user@123"
	And a senha "user"
	And seleciono entrar
	Then visualizo a pagina inicial
	When seleciono contas
	And seleciono Adicionar
	And seleciono salvar
	Then sou notificado que o nome da conta e obrigatorio	

	
	

