import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseURL = "http://localhost:8081/student/getAll";
  private addURL = "http://localhost:8081/student/add";
  private getURL = "http://localhost:8081/student/getById/";
  private updateURL = "http://localhost:8081/student/update/";
  private deleteURL = "http://localhost:8081/student/delete/";

  constructor(private httpClient: HttpClient) { }

  getStudentsList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}`);
  }

  createStudent(student: Student): Observable<Object>{
    return this.httpClient.post(`${this.addURL}`,student)
  }
  getStudentById(id: number): Observable<Student>{
    return this.httpClient.get<Student>(`${this.getURL}${id}`);
  }

  updateStudent(id: number, student: Student): Observable<Object>{
    return this.httpClient.put(`${this.updateURL}${id}`,student);
  } 
  deleteStudent(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.deleteURL}${id}`);
  }
}
