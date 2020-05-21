Feature: Contas
	As um usuario
	I quero cadastrar contas
	In poder distribuir meu dinheiro de forma organizada

Background:
	Given que estou acessando a aplicacao
	When informo o usuario "user@123"
	And a senha "user"
	And seleciono entrar
	Then visualizo a pagina inicial
	When seleciono contas
	And seleciono Adicionar
	
Scenario: Deve inserir uma conta com sucesso

	And informo a conta "Conta de teste"
	And seleciono salvar
	Then a conta e inserida com sucesso
	
Scenario: Nao deve inserir uma conta sem nome

	And seleciono salvar
	Then sou notificado que o nome da conta e obrigatorio	

	
	

