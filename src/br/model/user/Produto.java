package br.model.user;

public class Produto {
		
		/*Info Fornecedor*/
		private long codigoFornecedor;
		private String razaoSocial;
		
		/*Info Produto*/
		private long codigoProduto;
		private String descricaoPro;
		private float preco;
		
		/*Info Cliente*/
		private String nomeCliente;
		private long codigoCliente; 
		
		private long codigoVenda;
		private int quantidade;
		
		
		/*Get e Set*/
		
		public long getCodigoFornecedor() {
			return codigoFornecedor;
		}
		public void setCodigoFornecedor(long codigoFornecedor) {
			this.codigoFornecedor = codigoFornecedor;
		}
		
		
		public String getRazaoSocial() {
			return razaoSocial;
		}
		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}
		
		
		public long getCodigoProduto() {
			return codigoProduto;
		}
		public void setCodigoProduto(long codigoProduto) {
			this.codigoProduto = codigoProduto;
		}
		
		
		public String getDescricaoPro() {
			return descricaoPro;
		}
		public void setDescricaoPro(String descricaoPro) {
			this.descricaoPro = descricaoPro;
		}
		
		
		public float getPreco() {
			return preco;
		}
		public void setPreco(float preco) {
			this.preco = preco;
		}
		public String getNomeCliente() {
			return nomeCliente;
		}
		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}
		public long getCodigoCliente() {
			return codigoCliente;
		}
		public void setCodigoCliente(long codigoCliente) {
			this.codigoCliente = codigoCliente;
		}
		public long getCodigoVenda() {
			return codigoVenda;
		}
		public void setCodigoVenda(long codigoVenda) {
			this.codigoVenda = codigoVenda;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		
		
}
