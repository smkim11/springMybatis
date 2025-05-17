<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>접속 통계</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
    body {
        background-color: #eef2f7;
        padding: 40px 20px;
        font-family: 'Segoe UI', sans-serif;
    }
    .card {
        box-shadow: 0 4px 10px rgba(0,0,0,0.05);
        border: none;
        border-radius: 15px;
    }
    h2 {
        margin: 40px 0 20px;
        color: #343a40;
        font-weight: 600;
    }
    .table th {
        background-color: #f1f3f5;
        text-align: center;
    }
    .table td {
        text-align: center;
        vertical-align: middle;
    }
    .role-icon {
        margin-right: 6px;
    }
    .section-title i {
        margin-right: 8px;
        color: #0d6efd;
    }
</style>
</head>
<body>
<div class="container">

    <!-- 전체 -->
    <h2 class="section-title"><i class="fas fa-users"></i>전체 접속자 수</h2>
    <div class="card p-3">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th><i class="fas fa-user-secret role-icon text-secondary"></i>익명 사용자</th>
                    <th><i class="fas fa-user role-icon text-success"></i>회원</th>
                    <th><i class="fas fa-user-shield role-icon text-danger"></i>관리자</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${connectCountMapAll.ANONYMOUS}</td>
                    <td>${connectCountMapAll.MEMBER}</td>
                    <td>${connectCountMapAll.ADMIN}</td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- 오늘 -->
    <h2 class="section-title"><i class="fas fa-calendar-day"></i>오늘 접속자 수</h2>
    <div class="card p-3">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th><i class="fas fa-user-secret role-icon text-secondary"></i>익명 사용자</th>
                    <th><i class="fas fa-user role-icon text-success"></i>회원</th>
                    <th><i class="fas fa-user-shield role-icon text-danger"></i>관리자</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${connectCountMapToday.ANONYMOUS}</td>
                    <td>${connectCountMapToday.MEMBER}</td>
                    <td>${connectCountMapToday.ADMIN}</td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- 현재 접속자 수 -->
    <h2 class="section-title"><i class="fas fa-signal"></i>현재 접속자 수</h2>
    <div class="card p-3">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th><i class="fas fa-network-wired role-icon text-primary"></i>총 접속 중</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${currentConnectCount}</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>