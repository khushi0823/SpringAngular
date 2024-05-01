import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrl: './students-list.component.css'
})
export class StudentsListComponent {
  students: Student[];

  constructor(private studentService: StudentService, private router: Router){}
  

  ngOnInit(): void{
    this.getStudents();
  }

  private getStudents(){
    this.studentService.getStudentsList().subscribe(data =>{
      this.students = data;
    });
  }

  updateStudent(id: number){
    this.router.navigate(['update-student', id]);
  }
  
  deleteStudent(id: number){
    this.studentService.deleteStudent(id).subscribe(data =>{
      console.log(data);
      this.getStudents();
    });
  }
  studentDetails(id: number){
    this.router.navigate(['student-details', id]);
  }

}
