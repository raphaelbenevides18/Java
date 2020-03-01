export class Livro{

    idLivro: number;
    titulo: string;
	autor: string;
	categoria: string;
	descricao: string;
	numPaginas: number;
    imagem: string;
    
    constructor(idLivro?:number, titulo?: string, autor?: string, categoria?: string, 
        descricao?: string, numPaginas?: number, imagem?: string){
            this.idLivro=idLivro;
            this.titulo=titulo;
            this.autor=autor;
            this.categoria=categoria;
            this.descricao=descricao;
            this.numPaginas=numPaginas;
            this.imagem=imagem;
        }

}