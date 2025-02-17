import { Component, Renderer2, ElementRef, ViewChild, OnInit  } from '@angular/core';
import { RouterOutlet, RouterModule, Router, NavigationEnd } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterModule, NgIf],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'BankAccountApplication';
  currentUrl: string = '';
  
  @ViewChild('header', { static: true }) header!: ElementRef;
  @ViewChild('sidebar', { static: true }) sidebar!: ElementRef
  @ViewChild('menuButton', { static: true }) menuButton!: ElementRef;
  @ViewChild('content', { static: true }) content!: ElementRef; 

  constructor(private renderer: Renderer2, private router: Router) {}
  
  ngOnInit() {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.currentUrl = event.url; 
      }
    });
  }
  
  isHomePage(): boolean {
    if (this.currentUrl == '/') {
      this.renderer.removeClass(this.content.nativeElement, 'shifted-right');
	}
    return this.currentUrl == '/';
  }

  isCreateCustomerPage(): boolean {
    if (this.currentUrl.includes('Create_Customer')) {
	    this.renderer.removeClass(this.content.nativeElement, 'shifted-right');
	}
    return this.currentUrl.includes('Create_Customer');
  }
  
  isUpdateCustomerPage(): boolean {
    if (this.currentUrl.includes('Update_Customer')) {
	    this.renderer.removeClass(this.content.nativeElement, 'shifted-right');
	}
    return this.currentUrl.includes('Update_Customer');
  }
  
  isCreateAccountPage(): boolean {
    if (this.currentUrl.includes('Create_Account')) {
	    this.renderer.removeClass(this.content.nativeElement, 'shifted-right');
	}
    return this.currentUrl.includes('Create_Account');
  }
  
  isUpdateAccountPage(): boolean {
    if (this.currentUrl.includes('Update_Account')) {
	    this.renderer.removeClass(this.content.nativeElement, 'shifted-right');
	}
    return this.currentUrl.includes('Update_Account');
  }

  toggleSidebar() {
    this.renderer.removeClass(this.sidebar.nativeElement, 'hide');
    this.renderer.removeClass(this.menuButton.nativeElement, 'show');
    
    // Toggle sidebar visibility
    if (this.sidebar.nativeElement.classList.contains('show')) {
      this.renderer.removeClass(this.sidebar.nativeElement, 'show');
      this.renderer.removeClass(this.content.nativeElement, 'shifted-right');
    } else {
      this.renderer.addClass(this.sidebar.nativeElement, 'show');
      this.renderer.addClass(this.content.nativeElement, 'shifted-right');
    }
    
    if (this.menuButton.nativeElement.classList.contains('hide')) {
      this.renderer.removeClass(this.menuButton.nativeElement, 'hide');
    } else {
      this.renderer.addClass(this.menuButton.nativeElement, 'hide');
    }
  }

  toggleMenuBar() {
    if (this.sidebar.nativeElement.classList.contains('hide')) {
     this.renderer.removeClass(this.sidebar.nativeElement, 'hide');
    } else {
      this.renderer.addClass(this.sidebar.nativeElement, 'hide');
      this.renderer.removeClass(this.content.nativeElement, 'shifted-right');
    }

    if (this.menuButton.nativeElement.classList.contains('show')) {
      this.renderer.removeClass(this.menuButton.nativeElement, 'show');
    } else {
      this.renderer.addClass(this.menuButton.nativeElement, 'show');
    }
  }
  
}

