import { inject, Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { ConfirmarDialogComponent } from '../confirmar-dialog/confirmar-dialog.component';

@Injectable({
  providedIn: 'root'
})
export class UiService {
  private dialog = inject(MatDialog);
  private snackBar = inject(MatSnackBar);
  horizontalPosition: MatSnackBarHorizontalPosition = 'right';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  showSnackBar(message: string): void {
    this.snackBar.open(message, 'OK', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: 4000
    });
  }

  showConfirmationDialog(): Observable<boolean> {
    const dialogRef = this.dialog.open(ConfirmarDialogComponent);
    return dialogRef.afterClosed();
  }
}
