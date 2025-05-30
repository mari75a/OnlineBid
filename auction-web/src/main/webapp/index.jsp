<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Live Auction Platform</title>
    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-5">
    <div class="text-center mb-4">
        <h1 class="display-5">🌐 Live Online Auction System</h1>
        <p class="lead">Bid in real-time. Compete with users around the world. Win your favorite items!</p>
    </div>

    <div class="row">
        <!-- Start/End Auction Form -->
        <div class="col-md-6">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">Manage Auction</div>
                <div class="card-body">
                    <form method="post" action="auction">
                        <div class="mb-3">
                            <label for="itemId" class="form-label">Item ID</label>
                            <input type="text" class="form-control" id="itemId" name="itemId" required>
                        </div>
                        <div class="mb-3">
                            <label for="action" class="form-label">Action</label>
                            <select class="form-select" id="action" name="action" required>
                                <option value="start">Start Auction</option>
                                <option value="end">End Auction</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Submit</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Place Bid Form -->
        <div class="col-md-6 mt-4 mt-md-0">
            <div class="card shadow-sm">
                <div class="card-header bg-success text-white">Place Your Bid</div>
                <div class="card-body">
                    <form method="post" action="placeBid">
                        <div class="mb-3">
                            <label for="user" class="form-label">Your Name</label>
                            <input type="text" class="form-control" id="user" name="user" required>
                        </div>
                        <div class="mb-3">
                            <label for="itemIdBid" class="form-label">Item ID</label>
                            <input type="text" class="form-control" id="itemIdBid" name="itemId" required>
                        </div>
                        <div class="mb-3">
                            <label for="amount" class="form-label">Bid Amount ($)</label>
                            <input type="number" step="0.01" class="form-control" id="amount" name="amount" required>
                        </div>
                        <button type="submit" class="btn btn-success w-100">Place Bid</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <footer class="mt-5 text-center text-muted small">
        Powered by EJB & JMS • Distributed Auction System • 2025
    </footer>
</div>

<!-- Bootstrap JS (optional for components) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
