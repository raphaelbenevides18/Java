import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Livro } from'../model/livro';

const URL: string = "http://localhost:8080/livrotecaREST/rs/livro";

@Injectable()
export class LivroService{

    constructor(private http: HttpClient){

    }

        public create(livro: Livro){
            return this.http.post<Livro>(`${URL}`, livro);
        }

        public findAll(){
            return this.http.get<Livro[]>(`${URL}`);
        }
    
}