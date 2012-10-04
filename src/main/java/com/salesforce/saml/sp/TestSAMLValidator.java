package com.salesforce.saml.sp;


import com.salesforce.saml.Identity;

public class TestSAMLValidator {


    private static String SAMLResponse = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48c2FtbHA6UmVzcG9uc2UgeG1sbnM6c2FtbHA9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpwcm90b2NvbCIgRGVzdGluYXRpb249Imh0dHBzOi8vc2FsZXNmb3JjZWlkZW50aXR5Lmhlcm9rdWFwcC5jb20vc2FtbC8iIElEPSJfYjAwYzExNWEyM2FjNjE5NmJjMzcwMTRiOTFkMzc1YmMxMzQ5MjI1MjI3MTQwIiBJc3N1ZUluc3RhbnQ9IjIwMTItMTAtMDNUMDA6NDc6MDcuMTQwWiIgVmVyc2lvbj0iMi4wIj48c2FtbDpJc3N1ZXIgeG1sbnM6c2FtbD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiIgRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6bmFtZWlkLWZvcm1hdDplbnRpdHkiPmh0dHBzOi8vaWRlbnRpdHkucHJlcmVsbmExLnByZS5teS5zYWxlc2ZvcmNlLmNvbTwvc2FtbDpJc3N1ZXI+PGRzOlNpZ25hdHVyZSB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+CjxkczpTaWduZWRJbmZvIHhtbG5zOmRzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj4KPGRzOkNhbm9uaWNhbGl6YXRpb25NZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiIHhtbG5zOmRzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIi8+CjxkczpTaWduYXR1cmVNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjcnNhLXNoYTEiIHhtbG5zOmRzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIi8+CjxkczpSZWZlcmVuY2UgVVJJPSIjX2IwMGMxMTVhMjNhYzYxOTZiYzM3MDE0YjkxZDM3NWJjMTM0OTIyNTIyNzE0MCIgeG1sbnM6ZHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPgo8ZHM6VHJhbnNmb3JtcyB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+CjxkczpUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25hdHVyZSIgeG1sbnM6ZHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiLz4KPGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyIgeG1sbnM6ZHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxlYzpJbmNsdXNpdmVOYW1lc3BhY2VzIHhtbG5zOmVjPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiIFByZWZpeExpc3Q9ImRzIHNhbWwgc2FtbHAgeHMiLz48L2RzOlRyYW5zZm9ybT4KPC9kczpUcmFuc2Zvcm1zPgo8ZHM6RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3NoYTEiIHhtbG5zOmRzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIi8+CjxkczpEaWdlc3RWYWx1ZSB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+Lzg4eDQveC9LOWM0TFVlcDFBV3JHRCsreUVJPTwvZHM6RGlnZXN0VmFsdWU+CjwvZHM6UmVmZXJlbmNlPgo8L2RzOlNpZ25lZEluZm8+CjxkczpTaWduYXR1cmVWYWx1ZSB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+CmlCb3pLNUhEU2lUNDBTUFFaclVWbzFnKzhBbnd0dkNhZ2VRaFp1MFNheTNqNmtWQ2JqWmEvQ0FpaWFvc1hWT2pBZG1qSU8wa2RlVFAKQUlEVXdnNGpNeTVhRDZOR3p0Zmh4bjFXZGhXd2VYUUlsOGlTRjZCWnlkUU1yTzFOMnlsRTR4b0Q1aHhpZ01Wa0pXWWIwaGZVWExlYQpTSE92YmNpemk2QjFET3JPRXFXb1MzU2tQK1R0dTFBSEdtSWZTSUJ5VDh5TldlTXlQcTRlTVBHa2t5Vlg1WU4ySlZTRlllUWhZcnZuCm5RYjlrSCtyMnVVQWxTN2krZGdtaVNpSmQxKzNuZGd5bm9SQkQ1bk9VeVpPWFpwL1JCMzJRbGc0UGxMMUxQUEtEaWgveDJMN2VCYXMKZGh5NUdvaTVsV01oSWVldmZ0TUMyTHhrMDdEUDRWU1ZkNUxLZXc9PQo8L2RzOlNpZ25hdHVyZVZhbHVlPgo8ZHM6S2V5SW5mbz48ZHM6WDUwOURhdGE+PGRzOlg1MDlDZXJ0aWZpY2F0ZT5NSUlFWnpDQ0EwK2dBd0lCQWdJT0FUbVV5RVhCQUFBQUFIRDMvQXN3RFFZSktvWklodmNOQVFFRkJRQXdlekVUTUJFR0ExVUVBd3dLClRYa2dRMjl0Y0dGdWVURVlNQllHQTFVRUN3d1BNREJFZURBd01EQXdNREE1VmxGdE1SY3dGUVlEVlFRS0RBNVRZV3hsYzJadmNtTmwKTG1OdmJURVdNQlFHQTFVRUJ3d05VMkZ1SUVaeVlXNWphWE5qYnpFTE1Ba0dBMVVFQ0F3Q1EwRXhEREFLQmdOVkJBWVRBMVZUUVRBZQpGdzB4TWpBNU1EVXdORFUxTVRaYUZ3MHhOREE1TURVd05EVTFNVFphTUhzeEV6QVJCZ05WQkFNTUNrMTVJRU52YlhCaGJua3hHREFXCkJnTlZCQXNNRHpBd1JIZ3dNREF3TURBd09WWlJiVEVYTUJVR0ExVUVDZ3dPVTJGc1pYTm1iM0pqWlM1amIyMHhGakFVQmdOVkJBY00KRFZOaGJpQkdjbUZ1WTJselkyOHhDekFKQmdOVkJBZ01Ba05CTVF3d0NnWURWUVFHRXdOVlUwRXdnZ0VpTUEwR0NTcUdTSWIzRFFFQgpBUVVBQTRJQkR3QXdnZ0VLQW9JQkFRQ1h3RFdPNzNjdTNySGlzR2wzYVE2MFp5R0JRUmt3NU5EVEQ4YjczZnFiMG9BMTZ0ZkY3WXJECllac1VYQzMxckU2QW1QSEhQTFBhTlRTaFZGOVpwUTh3MmRPOVFNMFcwWkQxSldMWVBJVHRtV0lSczkvbnZVaGpvaXJ3dkp0M2V5cHYKY0MzMU9GSWp5bEgvN0hGRXByT1VEM0JqVzlxVC95cDhTYW1QR3gyWXBnV25pNlM4Y0lvQXFyK3VQVXRFSzJGNlZYL0F5ZS9Xc2dFbwoyeDZ5OTNoVXk1M2dmbEZMK1hsMzl1R3NzQ1VBamN3dGlNcmVaUzJQaDRaa25HbldNV2pQc1BBWE9kb1EwWWkwYzZGVVh3cWZUcUJBCkRMd1JSVXhyWDloTWNXWU8vZW8yU1dHZFMrVDIvN0N0TjF1NHNTWEVqVXJvdXA1MGdwMC83ODRmaCtBYkFnTUJBQUdqZ2Vnd2dlVXcKSFFZRFZSME9CQllFRkk0UWFVaGM5OS9tNDZrRVcwRThaeXlrU2pTU01JR3lCZ05WSFNNRWdhb3dnYWVBRkk0UWFVaGM5OS9tNDZrRQpXMEU4Wnl5a1NqU1NvWCtrZlRCN01STXdFUVlEVlFRRERBcE5lU0JEYjIxd1lXNTVNUmd3RmdZRFZRUUxEQTh3TUVSNE1EQXdNREF3Ck1EbFdVVzB4RnpBVkJnTlZCQW9NRGxOaGJHVnpabTl5WTJVdVkyOXRNUll3RkFZRFZRUUhEQTFUWVc0Z1JuSmhibU5wYzJOdk1Rc3cKQ1FZRFZRUUlEQUpEUVRFTU1Bb0dBMVVFQmhNRFZWTkJnZzRCT1pUSVJjTUFBQUFBY1BmOEN6QVBCZ05WSFJNQkFmOEVCVEFEQVFILwpNQTBHQ1NxR1NJYjNEUUVCQlFVQUE0SUJBUUEwSlM0NTZQd0dkSUtha2hjVnVMNHhBUndSTHVvbkF2Y2RQZHlMNk5qa3hyb3VaVzdlClFzczFMZHFLR1V5djZ6SnhKV3FXckhHL1RFOEZsUjNLSlJ1bGVkL1dFVkFYRmZqcEZUTzQweWlORHM0VTZpaDlQVGVTNmtlL3JWdk0KNlFVTzZUdmRqZG42SElNYitFSWIzQnl1QWtuYW9FRHd4enkrNmZFc2hNUnRpUGc4bVArWHJuanJBWmtIMERGNjVXVExNY25VNnBGQgptYU5Pd2VUVm9KMkdHclo3eUwzU3MzRDdnU0xEZFBiRW9JRDF4WjQyM0VKYXhTcjk2ZGkzRVpxU0lHWklUUzkwaXpyTGQ2Nmxjb1N0Ck1pRTB6Ri93VGU1cVZTWmI0QUsrYUdDWjl1NXFIVU9mallScnUzR3FtNU00UUZuUlpSdG81bExEV3o2bmZHTVE8L2RzOlg1MDlDZXJ0aWZpY2F0ZT48L2RzOlg1MDlEYXRhPjwvZHM6S2V5SW5mbz48L2RzOlNpZ25hdHVyZT48c2FtbHA6U3RhdHVzPjxzYW1scDpTdGF0dXNDb2RlIFZhbHVlPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6c3RhdHVzOlN1Y2Nlc3MiLz48L3NhbWxwOlN0YXR1cz48c2FtbDpBc3NlcnRpb24geG1sbnM6c2FtbD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiIgSUQ9Il83NzlhMThkYjdiOGQ4YzJiOGMwZTA1OTNiZDIzY2U2MzEzNDkyMjUyMjcxNDAiIElzc3VlSW5zdGFudD0iMjAxMi0xMC0wM1QwMDo0NzowNy4xNDBaIiBWZXJzaW9uPSIyLjAiPjxzYW1sOklzc3VlciBGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpuYW1laWQtZm9ybWF0OmVudGl0eSI+aHR0cHM6Ly9pZGVudGl0eS5wcmVyZWxuYTEucHJlLm15LnNhbGVzZm9yY2UuY29tPC9zYW1sOklzc3Vlcj48c2FtbDpTdWJqZWN0PjxzYW1sOk5hbWVJRCBGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjEuMTpuYW1laWQtZm9ybWF0OnVuc3BlY2lmaWVkIj5hZG1pbnFhQHFhcmVzcG9uZGVyLmluZm88L3NhbWw6TmFtZUlEPjxzYW1sOlN1YmplY3RDb25maXJtYXRpb24gTWV0aG9kPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6Y206YmVhcmVyIj48c2FtbDpTdWJqZWN0Q29uZmlybWF0aW9uRGF0YSBOb3RPbk9yQWZ0ZXI9IjIwMTItMTAtMDNUMDA6NTI6MDcuMTQwWiIgUmVjaXBpZW50PSJodHRwczovL3NhbGVzZm9yY2VpZGVudGl0eS5oZXJva3VhcHAuY29tL3NhbWwvIi8+PC9zYW1sOlN1YmplY3RDb25maXJtYXRpb24+PC9zYW1sOlN1YmplY3Q+PHNhbWw6Q29uZGl0aW9ucyBOb3RCZWZvcmU9IjIwMTItMTAtMDNUMDA6NDc6MDcuMTQwWiIgTm90T25PckFmdGVyPSIyMDEyLTEwLTAzVDAwOjUyOjA3LjE0MFoiPjxzYW1sOkF1ZGllbmNlUmVzdHJpY3Rpb24+PHNhbWw6QXVkaWVuY2U+aHR0cHM6Ly9zYWxlc2ZvcmNlaWRlbnRpdHkuaGVyb2t1YXBwLmNvbS9zYW1sMnNwLzwvc2FtbDpBdWRpZW5jZT48L3NhbWw6QXVkaWVuY2VSZXN0cmljdGlvbj48L3NhbWw6Q29uZGl0aW9ucz48c2FtbDpBdXRoblN0YXRlbWVudCBBdXRobkluc3RhbnQ9IjIwMTItMTAtMDNUMDA6NDc6MDcuMTQwWiI+PHNhbWw6QXV0aG5Db250ZXh0PjxzYW1sOkF1dGhuQ29udGV4dENsYXNzUmVmPnVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphYzpjbGFzc2VzOnVuc3BlY2lmaWVkPC9zYW1sOkF1dGhuQ29udGV4dENsYXNzUmVmPjwvc2FtbDpBdXRobkNvbnRleHQ+PC9zYW1sOkF1dGhuU3RhdGVtZW50PjxzYW1sOkF0dHJpYnV0ZVN0YXRlbWVudD48c2FtbDpBdHRyaWJ1dGUgTmFtZT0idXNlcklkIiBOYW1lRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXR0cm5hbWUtZm9ybWF0OnVuc3BlY2lmaWVkIj48c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4bWxuczp4cz0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTp0eXBlPSJ4czphbnlUeXBlIj4wMDV4MDAwMDAwMEU1QW48L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0idXNlcm5hbWUiIE5hbWVGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphdHRybmFtZS1mb3JtYXQ6dW5zcGVjaWZpZWQiPjxzYW1sOkF0dHJpYnV0ZVZhbHVlIHhtbG5zOnhzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeHNpOnR5cGU9InhzOmFueVR5cGUiPmFkbWluQGlkZW50aXR5ZGVtby5vcmc8L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0iZW1haWwiIE5hbWVGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphdHRybmFtZS1mb3JtYXQ6dW5zcGVjaWZpZWQiPjxzYW1sOkF0dHJpYnV0ZVZhbHVlIHhtbG5zOnhzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeHNpOnR5cGU9InhzOmFueVR5cGUiPmNtb3J0aW1vcmVAc2FsZXNmb3JjZS5jb208L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0iaXNfcG9ydGFsX3VzZXIiIE5hbWVGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphdHRybmFtZS1mb3JtYXQ6dW5zcGVjaWZpZWQiPjxzYW1sOkF0dHJpYnV0ZVZhbHVlIHhtbG5zOnhzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeHNpOnR5cGU9InhzOmFueVR5cGUiPmZhbHNlPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PHNhbWw6QXR0cmlidXRlIE5hbWU9IkFkZHJlc3MiIE5hbWVGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphdHRybmFtZS1mb3JtYXQ6dW5zcGVjaWZpZWQiPjxzYW1sOkF0dHJpYnV0ZVZhbHVlIHhtbG5zOnhzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeHNpOnR5cGU9InhzOmFueVR5cGUiPjEgTWFya2V0IFN0LCBTYW4gRnJhbmNpc2NvIENBLCA5NDEwNTwvc2FtbDpBdHRyaWJ1dGVWYWx1ZT48L3NhbWw6QXR0cmlidXRlPjxzYW1sOkF0dHJpYnV0ZSBOYW1lPSJhY2Nlc3NfdG9rZW4iIE5hbWVGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphdHRybmFtZS1mb3JtYXQ6dW5zcGVjaWZpZWQiPjxzYW1sOkF0dHJpYnV0ZVZhbHVlIHhtbG5zOnhzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeHNpOnR5cGU9InhzOmFueVR5cGUiPjAwRHgwMDAwMDAwOVZRbSFBUnNBUU5OQmVveHZpMU5hVVdOWHE0YVZOVEhkUkhxX0tDanlfcW56TzFVZE01MFNXbERwYTBlZHF5WDcxWERZWUEuT0JHVFhhcXphc3VWZy5ybzhvS1V5QjFHQXFLb3Y8L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0iRm9vIiBOYW1lRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXR0cm5hbWUtZm9ybWF0OnVuc3BlY2lmaWVkIj48c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4bWxuczp4cz0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTp0eXBlPSJ4czphbnlUeXBlIj5jbW9ydGltb3JlQHNhbGVzZm9yY2UuY29tPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PHNhbWw6QXR0cmlidXRlIE5hbWU9IkZvbyIgTmFtZUZvcm1hdD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmF0dHJuYW1lLWZvcm1hdDp1bnNwZWNpZmllZCI+PHNhbWw6QXR0cmlidXRlVmFsdWUgeG1sbnM6eHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hIiB4bWxuczp4c2k9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hLWluc3RhbmNlIiB4c2k6dHlwZT0ieHM6YW55VHlwZSI+MDBleDAwMDAwMDBFN1NyPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PHNhbWw6QXR0cmlidXRlIE5hbWU9Ik9yZ0lEIiBOYW1lRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXR0cm5hbWUtZm9ybWF0OnVuc3BlY2lmaWVkIj48c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4bWxuczp4cz0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTp0eXBlPSJ4czphbnlUeXBlIj4wMER4MDAwMDAwMDlWUW08L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0iRm9vIiBOYW1lRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXR0cm5hbWUtZm9ybWF0OnVuc3BlY2lmaWVkIj48c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4bWxuczp4cz0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTp0eXBlPSJ4czphbnlUeXBlIj5jbW9ydGltb3JlQHNhbGVzZm9yY2UuY29tPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PC9zYW1sOkF0dHJpYnV0ZVN0YXRlbWVudD48L3NhbWw6QXNzZXJ0aW9uPjwvc2FtbHA6UmVzcG9uc2U+";

    private static String cert = "-----BEGIN CERTIFICATE-----\n" +
            "MIIEZzCCA0+gAwIBAgIOATmUyEXBAAAAAHD3/AswDQYJKoZIhvcNAQEFBQAwezET\n" +
            "MBEGA1UEAwwKTXkgQ29tcGFueTEYMBYGA1UECwwPMDBEeDAwMDAwMDA5VlFtMRcw\n" +
            "FQYDVQQKDA5TYWxlc2ZvcmNlLmNvbTEWMBQGA1UEBwwNU2FuIEZyYW5jaXNjbzEL\n" +
            "MAkGA1UECAwCQ0ExDDAKBgNVBAYTA1VTQTAeFw0xMjA5MDUwNDU1MTZaFw0xNDA5\n" +
            "MDUwNDU1MTZaMHsxEzARBgNVBAMMCk15IENvbXBhbnkxGDAWBgNVBAsMDzAwRHgw\n" +
            "MDAwMDAwOVZRbTEXMBUGA1UECgwOU2FsZXNmb3JjZS5jb20xFjAUBgNVBAcMDVNh\n" +
            "biBGcmFuY2lzY28xCzAJBgNVBAgMAkNBMQwwCgYDVQQGEwNVU0EwggEiMA0GCSqG\n" +
            "SIb3DQEBAQUAA4IBDwAwggEKAoIBAQCXwDWO73cu3rHisGl3aQ60ZyGBQRkw5NDT\n" +
            "D8b73fqb0oA16tfF7YrDYZsUXC31rE6AmPHHPLPaNTShVF9ZpQ8w2dO9QM0W0ZD1\n" +
            "JWLYPITtmWIRs9/nvUhjoirwvJt3eypvcC31OFIjylH/7HFEprOUD3BjW9qT/yp8\n" +
            "SamPGx2YpgWni6S8cIoAqr+uPUtEK2F6VX/Aye/WsgEo2x6y93hUy53gflFL+Xl3\n" +
            "9uGssCUAjcwtiMreZS2Ph4ZknGnWMWjPsPAXOdoQ0Yi0c6FUXwqfTqBADLwRRUxr\n" +
            "X9hMcWYO/eo2SWGdS+T2/7CtN1u4sSXEjUroup50gp0/784fh+AbAgMBAAGjgegw\n" +
            "geUwHQYDVR0OBBYEFI4QaUhc99/m46kEW0E8ZyykSjSSMIGyBgNVHSMEgaowgaeA\n" +
            "FI4QaUhc99/m46kEW0E8ZyykSjSSoX+kfTB7MRMwEQYDVQQDDApNeSBDb21wYW55\n" +
            "MRgwFgYDVQQLDA8wMER4MDAwMDAwMDlWUW0xFzAVBgNVBAoMDlNhbGVzZm9yY2Uu\n" +
            "Y29tMRYwFAYDVQQHDA1TYW4gRnJhbmNpc2NvMQswCQYDVQQIDAJDQTEMMAoGA1UE\n" +
            "BhMDVVNBgg4BOZTIRcMAAAAAcPf8CzAPBgNVHRMBAf8EBTADAQH/MA0GCSqGSIb3\n" +
            "DQEBBQUAA4IBAQA0JS456PwGdIKakhcVuL4xARwRLuonAvcdPdyL6NjkxrouZW7e\n" +
            "Qss1LdqKGUyv6zJxJWqWrHG/TE8FlR3KJRuled/WEVAXFfjpFTO40yiNDs4U6ih9\n" +
            "PTeS6ke/rVvM6QUO6Tvdjdn6HIMb+EIb3ByuAknaoEDwxzy+6fEshMRtiPg8mP+X\n" +
            "rnjrAZkH0DF65WTLMcnU6pFBmaNOweTVoJ2GGrZ7yL3Ss3D7gSLDdPbEoID1xZ42\n" +
            "3EJaxSr96di3EZqSIGZITS90izrLd66lcoStMiE0zF/wTe5qVSZb4AK+aGCZ9u5q\n" +
            "HUOfjYRru3Gqm5M4QFnRZRto5lLDWz6nfGMQ\n" +
            "-----END CERTIFICATE-----";




    public static void main(String[] args) {

        SAMLValidator sv = new SAMLValidator();
        try {
            Identity identity = sv.validate(SAMLResponse, cert, "https://identity.prerelna1.pre.my.salesforce.com", "https://salesforceidentity.herokuapp.com/saml/", "https://salesforceidentity.herokuapp.com/saml2sp/");
            if (identity != null) System.out.println("Validated User: " + identity.getSubject());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}