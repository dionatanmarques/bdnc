conn = new Mongo();
db = conn.getDB("fa7");

db.createCollection("departamento");
db.createCollection("funcionario");

print("Iniciando inserção de departamentos");

var inicio = new Date().getTime();

print("Iniciando inserção de 8 departamentos " + new Date());

for (var i = 1; i <= 8; i++) {
	db.departamento.insert({
		_id: i,
		nome: "Departamento - " + i
	});
}

print("Inserção de 8 departamentos finalizada " + new Date());

var fim = new Date().getTime();

print("Tempo de processamento: " + (fim - inicio) + " milissegundos");

print("Iniciando inserção de funcionarios");

var inicio = new Date().getTime();

print("Iniciando inserção de 1000000 funcionarios " + new Date());

for (var i = 1; i <= 1000000; i++) {
	db.funcionario.insert({
		_id: i,
		nome: "Funcionario - " + i,
		departamento: 1
	});
}

print("Inserção de 1000000 funcionarios finalizada " + new Date());

var fim = new Date().getTime();

print("Tempo de processamento: " + (fim - inicio) + " milissegundos");

print("Iniciando leitura de funcionarios e departamentos");

print("Inicialdo FULL TABLE SCAN da tabela FUNCIONARIO");

var inicio = new Date().getTime();

var funcionarios = db.funcionario.find();

var fim = new Date().getTime();

print(funcionarios.length() + " funcionarios lidos em " + (fim - inicio) + " milissegundos");

print("Iniciando atualizaçao de funcionarios");

var inicio = new Date().getTime();

var updates = db.funcionario.update({}, {
	$set : {
		departamento: 2
	}
}, {
	multi: true
});

var fim = new Date().getTime();

print(updates.nModified + " funcionario(s) atualizados em " + (fim - inicio) + " milissegundos");

print("Iniciando exclusão de funcionarios");

var inicio = new Date().getTime();

var updates = db.funcionario.remove({});

var fim = new Date().getTime();

print("funcionario(s) removidos em " + (fim - inicio) + " milissegundos");