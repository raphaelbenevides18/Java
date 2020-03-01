import { Component, OnInit } from '@angular/core';
import { Livro } from '../model/livro';
import { LivroService } from '../service/livro.service';

@Component({
  selector: 'app-livro',
  templateUrl: './livro.component.html',
  styleUrls: ['./livro.component.css']
})
export class LivroComponent implements OnInit {

  livros: Livro[] = [];
  livro: Livro;
  msg : string = "";

  constructor(private service: LivroService) { 
    this.livro = new Livro();
  }

  ngOnInit(): void {
    this.listar();
  }

  public listar(){
    this.service.findAll().subscribe(res => {
      this.livros = res;
    });
  }

  public gravar(){
    this.service.create(this.livro).subscribe( res => {
      console.log('Livro gravado com sucesso', this.livro);
      this.listar();
      if(this.livro){
        this.msg = 'Livro gravado';
        this.livro = new Livro();
      }else{
        this.msg = 'Livro nao gravado...:('
      }
    });
  }

}
