using Microsoft.EntityFrameworkCore;

namespace RecodeViagens.Models
{
    public class GeralDbContext : DbContext
    {
        public GeralDbContext(DbContextOptions<GeralDbContext> options)
            : base(options) 
        { }

        public DbSet<Destino> Destinos { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Cargo> Cargos { get; set; }
    }
}
