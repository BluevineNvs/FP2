#!"C:\xampp\perl\bin\perl.exe"
use strict;
use warnings;
use CGI;
use CGI::Carp qw(fatalsToBrowser);
use DBI;

my $cgi = CGI->new;
print $cgi->header;

my $username = $cgi->param('username');
my $password = $cgi->param('password');

my $dbh = DBI->connect("dbi:SQLite:dbname=db/BaseDeDatos.db", "admin", "admin");
my $sth = $dbh->prepare("SELECT * FROM Users WHERE username = ? AND password = ?");
$sth->execute($username, $password);

if (my @row = $sth->fetchrow_array) {
    print $cgi->redirect('/cgi-bin/list.pl');
} else {
    print $cgi->start_html('Login Fallido');
    print $cgi->h1('Login Fallido');
    print $cgi->p('Usuario o contraseña incorrectos.');
    print $cgi->a({-href => '/cgi-bin/login.pl'}, 'Volver a Intentar');
    print $cgi->end_html;
}

$dbh->disconnect;
