import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptorInterceptor: HttpInterceptorFn = (req, next) => {
  const token = sessionStorage.getItem("token");
  if(token){
    req = req.clone({
      setHeaders:{
        Authorization: `Bearer ${token}`
      },
    });
  }
  return next(req);
};
