import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})


export class UpdateStudentComponent implements OnInit{

  id: number;
  isLoadinig: boolean = false;
  loadingTital: string ='';
  errors: any = [];
  student: Student =new Student();
  constructor(private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute ){}

  ngOnInit(): void{
    this.id = this.route.snapshot.params['id'];
    this.studentService.getStudentById(this.id).subscribe((data:any )=>{
      this.student = data;
      console.log(data);
    });
  }

  onSubmit(){
    this.studentService.updateStudent(this.id, this.student).subscribe(data =>{
      this.gotoList();
    });
  
  }

  gotoList(){
    this.router.navigate(['/students']);
  }

}
