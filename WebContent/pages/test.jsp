<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
</head>

<body>
<table id="datatable" style="width:100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nama Barang</th>
        <th>Kode Barang</th>
        <th>Jumlah Barang</th>
        <th>Tanggal</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>
</body>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<script>
    $(document).ready(function() {
        $('#datatable').DataTable({
            processing: true,
            searching: true,
            destroy: true,
            cache: true,
            contentType: "application/json; charset=utf-8",
            PaginationType: "full",
            ajax: {
                "url": "http://localhost:8080/git_test/getproduct",
                "type": "GET",
                "headers": {
                    'Content-Type': 'application/json'
                },
                "dataSrc": "value"
            },
            responsive: {
                breakpoints: [
                    {name: 'desktop', width: Infinity},
                    {name: 'tablet-l', width: 1024},
                    {name: 'tablet-p', width: 768},
                    {name: 'mobile-l', width: 480},
                    {name: 'mobile-p', width: 320}
                ]
            },
            columns: [
                {"data": "id"},
                {"data": "nama_barang"},
                {"data": "kode_barang"},
                {"data": "jumlah_barang"},
                {"data": "tanggal"}
            ],
            columnDefs: [
                {
                    targets: ['_all'],
                    searchable: true,
                    sortable: true,
                    visible: true,
                    defaultContent: ""
                }
            ]
        });
    } );
</script>
</html>